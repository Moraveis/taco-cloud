package com.spring.action.tacocloud.repository;

import com.spring.action.tacocloud.domain.Ingredient;
import com.spring.action.tacocloud.domain.Taco;
import com.spring.action.tacocloud.domain.TacoOrder;
import lombok.RequiredArgsConstructor;
import org.springframework.asm.Type;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Types;
import java.util.Date;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class JdbcOrderRepository implements OrderRepository {

    private final JdbcOperations jdbcOperations;

    @Override
    @Transactional
    public TacoOrder save(TacoOrder order) {
        String insertQuery = "insert into Taco_Order (delivery_name, delivery_street, delivery_city, delivery_state, delivery_zip, cc_number, cc_expiration, cc_cvv, placed_at) values (?,?,?,?,?,?,?,?,?)";
        int[] queryTypes = {Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.TIMESTAMP};

        PreparedStatementCreatorFactory statementCreatorFactory = new PreparedStatementCreatorFactory(insertQuery, queryTypes);
        statementCreatorFactory.setReturnGeneratedKeys(true);

        order.setPlacedAt(new Date());
        PreparedStatementCreator preparedStatementCreator =
                statementCreatorFactory.newPreparedStatementCreator(
                        List.of(order.getDeliveryName(), order.getDeliveryStreet(), order.getDeliveryCity(),
                                order.getDeliveryState(), order.getDeliveryZip(), order.getCcNumber(),
                                order.getCcExpiration(), order.getCcCVV(), order.getPlacedAt()));

        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcOperations.update(preparedStatementCreator, keyHolder);

        long orderId = keyHolder.getKey().longValue();
        order.setId(orderId);

        List<Taco> tacos = order.getTacos();
        int i = 0;
        for (Taco taco : tacos) {
            saveTaco(orderId, i++, taco);
        }

        return order;
    }

    private long saveTaco(Long orderId, int orderKey, Taco taco) {
        taco.setCreatedAt(new Date());

        String insertQuery = "insert into Taco (name, created_at, taco_order, taco_order_key) values (?, ?, ?, ?)";
        int[] queryTypes = {Types.VARCHAR, Types.TIMESTAMP, Type.LONG, Type.LONG};
        PreparedStatementCreatorFactory statementCreatorFactory = new PreparedStatementCreatorFactory(insertQuery, queryTypes);
        statementCreatorFactory.setReturnGeneratedKeys(true);

        PreparedStatementCreator preparedStatementCreator = statementCreatorFactory.newPreparedStatementCreator(
                List.of(taco.getName(), taco.getCreatedAt(), orderId, orderKey));

        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcOperations.update(preparedStatementCreator, keyHolder);

        long tacoId = keyHolder.getKey().longValue();
        taco.setId(tacoId);

        saveIngredientRefs(tacoId, taco.getIngredients());

        return tacoId;
    }

    private void saveIngredientRefs(Long tacoId, List<Ingredient> ingredients) {
        int key = 0;
        for (Ingredient ingredient : ingredients) {
            jdbcOperations.update("insert into Ingredient_Ref (ingredient, taco, taco_key) values (?, ?, ?)",
                    ingredient.getName(), tacoId, key++);
        }
    }
}

package tacos.data;

import java.sql.Timestamp;
import java.sql.Types;
import java.util.Arrays;
import java.util.Date;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import tacos.Ingredient;
import tacos.Taco;

@Repository
public class JdbcTacoRepository implements TacoRepository{
	
	private JdbcTemplate jdbc;
	public JdbcTacoRepository(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}
	
	@Override
	public Taco save(Taco taco) {
		long tacoId = saveTacoInfo(taco);
		taco.setId(tacoId);
		for(Ingredient ingredient : taco.getIngredients()) {
			saveIngredientToTaco(ingredient, tacoId);
		}
		return taco;
	}
	
	// Taco 테이블에 타코에 들어가는 재료들을 저장
	// 저장된 타코의 ID값을 반환한다
	private long saveTacoInfo(Taco taco) {
		taco.setCreatedAt(new Date());
		
		// TacoID를 반환하기 위해 psc와 keyHolder 필요
		PreparedStatementCreator psc = 
				new PreparedStatementCreatorFactory(
						"insert into Taco (name, createdAt) values (?, ?)",
						Types.VARCHAR, Types.TIMESTAMP).newPreparedStatementCreator(
								Arrays.asList(taco.getName(), new Timestamp(taco.getCreatedAt().getTime())));
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbc.update(psc, keyHolder);
		return keyHolder.getKey().longValue();
	}
	
	// Taco_Ingredients 테이블에 타코ID와 재료들을 저장
	private void saveIngredientToTaco(Ingredient ingredient,  long tacoId) {
		jdbc.update("insert into Taco_Ingredients (taco, ingredient) values (?, ?)", tacoId, ingredient.getId());
	}
}

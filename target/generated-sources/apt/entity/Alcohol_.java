package entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Alcohol.class)
public abstract class Alcohol_ {

	public static volatile SingularAttribute<Alcohol, String> name;
	public static volatile SingularAttribute<Alcohol, String> land;
	public static volatile SingularAttribute<Alcohol, Long> Id;
	public static volatile SingularAttribute<Alcohol, Integer> strenght;

	public static final String NAME = "name";
	public static final String LAND = "land";
	public static final String ID = "Id";
	public static final String STRENGHT = "strenght";

}


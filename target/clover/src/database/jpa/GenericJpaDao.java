/* $$ This file has been instrumented by Clover 4.3.1#20180921211537623 $$ */package database.jpa;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.google.inject.persist.Transactional;

/**
 * Generic JPA DAO class that provides JPA support for the entity class
 * specified.
 *
 * @param <T> the type of the entity class
 */
public abstract class GenericJpaDao<T> {public static class __CLR4_3_11c1cjvm4k8gq{public static com_atlassian_clover.CoverageRecorder R;public static com_atlassian_clover.CloverProfile[] profiles = { };@java.lang.SuppressWarnings("unchecked") public static <I, T extends I> I lambdaInc(final int i,final T l,final int si){java.lang.reflect.InvocationHandler h=new java.lang.reflect.InvocationHandler(){public java.lang.Object invoke(java.lang.Object p,java.lang.reflect.Method m,java.lang.Object[] a) throws Throwable{R.inc(i);R.inc(si);try{return m.invoke(l,a);}catch(java.lang.reflect.InvocationTargetException e){throw e.getCause()!=null?e.getCause():new RuntimeException("Clover failed to invoke instrumented lambda",e);}}};return (I)java.lang.reflect.Proxy.newProxyInstance(l.getClass().getClassLoader(),l.getClass().getInterfaces(),h);}static{com_atlassian_clover.CoverageRecorder _R=null;try{com_atlassian_clover.CloverVersionInfo.An_old_version_of_clover_is_on_your_compilation_classpath___Please_remove___Required_version_is___4_3_1();if(20180921211537623L!=com_atlassian_clover.CloverVersionInfo.getBuildStamp()){com_atlassian_clover.Clover.l("[CLOVER] WARNING: The Clover version used in instrumentation does not match the runtime version. You need to run instrumented classes against the same version of Clover that you instrumented with.");com_atlassian_clover.Clover.l("[CLOVER] WARNING: Instr=4.3.1#20180921211537623,Runtime="+com_atlassian_clover.CloverVersionInfo.getReleaseNum()+"#"+com_atlassian_clover.CloverVersionInfo.getBuildStamp());}R=com_atlassian_clover.Clover.getNullRecorder();_R=com_atlassian_clover.Clover.getNullRecorder();_R=com_atlassian_clover.Clover.getRecorder("\u002f\u0068\u006f\u006d\u0065\u002f\u0062\u0061\u0062\u006c\u0061\u006e\u002f\u0044\u006f\u006b\u0075\u006d\u0065\u006e\u0074\u0075\u006d\u006f\u006b\u002f\u0073\u0077\u0065\u002f\u0050\u0072\u006f\u006a\u0065\u006b\u0074\u0032\u002e\u0030\u002f\u0074\u0061\u0072\u0067\u0065\u0074\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002f\u0063\u006c\u006f\u0076\u0065\u0072\u002e\u0064\u0062",1557737288587L,8589935092L,65,profiles,new java.lang.String[]{"clover.distributed.coverage",null});}catch(java.lang.SecurityException e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because it has insufficient security privileges. Please consult the Clover documentation on the security policy file changes required. ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.NoClassDefFoundError e){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised. Are you sure you have Clover in the runtime classpath? ("+e.getClass()+":"+e.getMessage()+")");}catch(java.lang.Throwable t){java.lang.System.err.println("[CLOVER] FATAL ERROR: Clover could not be initialised because of an unexpected error. ("+t.getClass()+":"+t.getMessage()+")");}R=_R;}}public static final com_atlassian_clover.TestNameSniffer __CLR4_3_1_TEST_NAME_SNIFFER=com_atlassian_clover.TestNameSniffer.NULL_INSTANCE;

    protected Class<T> entityClass;
    protected EntityManager entityManager;

    /**
     * Constructs a {@code GenericJpaDao} object.
     *
     * @param entityClass the {@link Class} object that represents the entity
     *                    class
     */
    public GenericJpaDao(Class<T> entityClass) {try{__CLR4_3_11c1cjvm4k8gq.R.inc(48);
        __CLR4_3_11c1cjvm4k8gq.R.inc(49);this.entityClass = entityClass;
    }finally{__CLR4_3_11c1cjvm4k8gq.R.flushNeeded();}}

    /**
     * Returns the underlying {@link EntityManager} instance.
     *
     * @return the underlying {@link EntityManager} instance
     */
    public EntityManager getEntityManager() {try{__CLR4_3_11c1cjvm4k8gq.R.inc(50);
        __CLR4_3_11c1cjvm4k8gq.R.inc(51);return entityManager;
    }finally{__CLR4_3_11c1cjvm4k8gq.R.flushNeeded();}}

    /**
     * Sets the underlying {@link EntityManager} instance.
     *
     * @param entityManager the underlying {@link EntityManager} instance
     */
    @Inject
    public void setEntityManager(EntityManager entityManager) {try{__CLR4_3_11c1cjvm4k8gq.R.inc(52);
        __CLR4_3_11c1cjvm4k8gq.R.inc(53);this.entityManager = entityManager;
    }finally{__CLR4_3_11c1cjvm4k8gq.R.flushNeeded();}}

    /**
     * Persists the specified entity instance in the database.
     *
     * @param entity the entity instance to be persisted in the database
     */
    @Transactional
    public void persist(T entity) {try{__CLR4_3_11c1cjvm4k8gq.R.inc(54);
        __CLR4_3_11c1cjvm4k8gq.R.inc(55);entityManager.persist(entity);
    }finally{__CLR4_3_11c1cjvm4k8gq.R.flushNeeded();}}

    /**
     * Returns the entity instance with the specified primary key from the
     * database. The method returns an empty {@link Optional} object when
     * the instance does not exists.
     *
     * @param primaryKey the primary key to look for
     * @return an {@link Optional} object wrapping the entity instance with
     * the specified primary key
     */
    @Transactional
    public Optional<T> find(Object primaryKey) {try{__CLR4_3_11c1cjvm4k8gq.R.inc(56);
        __CLR4_3_11c1cjvm4k8gq.R.inc(57);return Optional.ofNullable(entityManager.find(entityClass, primaryKey));
    }finally{__CLR4_3_11c1cjvm4k8gq.R.flushNeeded();}}

    /**
     * Returns the list of all instances of the entity class from the database.
     *
     * @return the list of all instances of the entity class from the database
     */
    @Transactional
    public List<T> findAll() {try{__CLR4_3_11c1cjvm4k8gq.R.inc(58);
        __CLR4_3_11c1cjvm4k8gq.R.inc(59);TypedQuery<T> typedQuery = entityManager.createQuery("FROM " + entityClass.getSimpleName(), entityClass);
        __CLR4_3_11c1cjvm4k8gq.R.inc(60);return typedQuery.getResultList();
    }finally{__CLR4_3_11c1cjvm4k8gq.R.flushNeeded();}}

    /**
     * Removes the specified entity instance from the database.
     *
     * @param entity the entity instance to be removed from the database
     */
    @Transactional
    public void remove(T entity) {try{__CLR4_3_11c1cjvm4k8gq.R.inc(61);
        __CLR4_3_11c1cjvm4k8gq.R.inc(62);entityManager.remove(entity);
    }finally{__CLR4_3_11c1cjvm4k8gq.R.flushNeeded();}}

    /**
     * Updates the specified entity instance in the database.
     *
     * @param entity the entity instance to be updated in the database
     */
    @Transactional
    public void update(T entity) {try{__CLR4_3_11c1cjvm4k8gq.R.inc(63);
        __CLR4_3_11c1cjvm4k8gq.R.inc(64);entityManager.merge(entity);
    }finally{__CLR4_3_11c1cjvm4k8gq.R.flushNeeded();}}

}

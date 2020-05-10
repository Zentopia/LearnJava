package com.utopia.java.lang.singleton;

/**
 * @author utopia on 2020/5/10
 */
public class LearnLazySingleton {

    // volatile 防止指令重排序，synchronized 不能防止指令重排序
    private static volatile LearnLazySingleton instance = null;

    //为什么不在这里 synchronized, 这样每次访问都需要同步，高并发下性能损失大
    public static LearnLazySingleton getInstance(){
        if (instance == null){
            synchronized (LearnLazySingleton.class){
                //为什么双重判断，因为第一次判断的时候是非同步的，判断完成后还有可能发生 instance 被赋值
                if (instance == null){
                    instance = new LearnLazySingleton(); //会发生指令重排序，导致实例还未初始化赋值给 instance，被其它线程获取
                }
            }
        }
        return instance;
    }

}

package com.example.optional;

import com.example.method_reference.Employ;
import com.example.method_reference.EmployData;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

public class Test01 {
    
    // 创建Optional类对象的三种方法
    @Test
    public void test01() {
        // static <T> Optional<T>	of(T value)
        // 返回具有 Optional的当前非空值的Optional。
        Girl girl = new Girl();
        // girl = null;
        Optional<Girl> optionalGirl = Optional.of(girl);// of方法参数必须非空
        System.out.println(optionalGirl);
        System.out.println("-----------------------------------");
        // static <T> Optional<T>	ofNullable(T value)
        // 返回一个 Optional指定值的Optional，如果非空，则返回一个空的 Optional 。
        girl = null;
        Optional<Girl> girlOptional = Optional.ofNullable(girl);// ofNullable参数可以为空，返回Optional.empty
        System.out.println(girlOptional);
        System.out.println("-----------------------------------");
        // static <T> Optional<T>	empty()
        // 返回一个空的 Optional实例。   
        Optional<Object> empty = Optional.empty();
        System.out.println(empty);
    }
    // 获取男孩的女孩姓名
    public String getGirlName(Boy boy) {
        // 原先这样做---java.lang.NullPointerException
        // return boy.getGirl().getName();
        // 为了避免空指针异常，现在这样做
        /*还是繁琐
        if (boy != null) {
            Girl girl = boy.getGirl();
            if (girl != null) {
                return girl.getName();
            }
        }
        return null;*/
        // 有了Optional之后
        // T	orElse(T other)
        //  返回值如果存在则返回，否则返回 other 。
        Optional<Boy> boyOptional = Optional.ofNullable(boy);
        // 此时的boy一点非空
        Boy boy1 = boyOptional.orElse(new Boy(new Girl("古力娜扎")));
        // boyOptional.orElseGet(Boy::new);
        Optional<Girl> girlOptional = Optional.ofNullable(boy1.getGirl());

        Girl girl = girlOptional.orElse(new Girl("迪丽热巴"));
        
        return girl.getName();
    }
    @Test
    public void test02() {
        Boy boy = new Boy();
        // boy = null;
        String girlName = getGirlName(boy);
        System.out.println(girlName);
    }
}

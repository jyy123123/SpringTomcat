package com.example.test;

import com.example.servlet.HelloServlet;
import com.sun.org.apache.xpath.internal.operations.UnaryOperation;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;
import java.util.function.ToDoubleFunction;
import java.util.function.UnaryOperator;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author yangyang.jiang
 * @Description:
 * @create 2020/7/16
 * @time 3:49 下午
 */
public class StreamTest {

    /*public static void main(String[] args) throws IOException {
        //根据路径获取文件的内容
        String str = new String(Files.readAllBytes(Paths.get("/Users/yigu/IdeaProjects/Spring_tomcat/src/main/resources/context.txt")));
        System.out.println(str);
        List<String> list = new ArrayList<>();
        long count = list.stream().filter(i -> i.equals("123")).count();
        System.out.println(count);
    }*/

    static class Product {
        public Product(String name, BigDecimal price) {
            this.name = name;
            this.price = price;
        }

        public Product() {
        }

        private String name;

        private BigDecimal price;

        public BigDecimal getPrice() {
            return price;
        }

        public void setPrice(BigDecimal price) {
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Product{" +
                    "name='" + name + '\'' +
                    ", price=" + price +
                    '}';
        }
    }

    public static void main(String[] args) throws Throwable {
        /*List<String> stringList = new ArrayList<>();
        stringList.add("123");
        stringList.add("2324");
        stringList = stringList.parallelStream().filter("123"::equals).collect(Collectors.toList());*/


        //supplier用于创建对象不同与new
        /*Supplier<HelloServlet> stringSupplier = HelloServlet::new;
        HelloServlet helloServlet = stringSupplier.get();
        System.out.println(helloServlet.toString());*/
        //Stream<BigInteger> iterate = Stream.iterate(BigInteger.ZERO, n -> BigInteger.ONE);


        /*Stream<String> word = Pattern.compile("\\PL+").splitAsStream("我真的无语了 kokoko妈妈  你们");
        word.forEach(System.out::println);*/

        //创建流的各种方式
        /*Stream<Object> stream = new ArrayList<>().stream();
        Stream<String> stringStream = Stream.of("123");
        Stream<String> generate = Stream.generate(() -> "123");
        Stream<Object> empty = Stream.empty();
        List<String> stringList = new ArrayList<>();
        stringList.add("123");
        stringList.add("2324");
        stringList.stream().limit(1).collect(Collectors.toList()).forEach(System.out::println);*/

        //流limit表示流的限制
        /*Stream<Double> limit = Stream.generate(Math::random).limit(100);
        limit.forEach(System.out::println);
        //流的跳过
        limit.skip(1);
        //流的拼接
        Stream.concat(Stream.empty(),Stream.empty());*/

        //流的排序问题
        /*Product product = new Product("哈哈",BigDecimal.valueOf(1));
        Product product1 = new Product("123",BigDecimal.valueOf(2.0));
        Product product2 = new Product("ni",BigDecimal.valueOf(3.3));
        List<Product> products = new ArrayList<>();
        products.add(product);
        products.add(product1);
        products.add(product2);
        List<Product> collect = products.stream().sorted(Comparator.comparing(Product::getPrice).reversed()).collect(Collectors.toList());
        collect.forEach(System.out::println);*/

        /*Object[] objects = Stream.iterate(1.0, p -> p * 2).peek(System.out::println).limit(100).toArray();*/

       /* Stream<String> stringStream = Stream.of("123", "444");
        Optional<String> any = stringStream.findAny();
        System.out.println(any.orElse(""));*/

       /* Product product = new Product();
        Optional<String> optional = Optional.ofNullable(product.getName());
        String s = optional.orElseGet(() -> Locale.getDefault().getDisplayName());
        System.out.println(s);
        String displayName = Locale.getDefault().getDisplayName();
        System.out.println(displayName);*/

        //根号计算
        System.out.println(Math.sqrt(9));

        //使用流进行计算
        /*List<Product> list = new ArrayList<>();
        list.add(new Product("1",BigDecimal.valueOf(123)));
        list.add(new Product("2",BigDecimal.valueOf(456)));
        String collect = list.stream().map(Product::toString).collect(Collectors.joining(","));
        Stream<BigDecimal> bigDecimalStream = list.stream().map(Product::getPrice);
        DoubleSummaryStatistics doubleSummaryStatistics = bigDecimalStream.map(BigDecimal::doubleValue).collect(Collectors.summarizingDouble(value -> value));
        System.out.println("总和为："+doubleSummaryStatistics.getSum());
        System.out.println("平均为："+doubleSummaryStatistics.getAverage());
        System.out.println(collect);*/


        //使用stream进行映射表
        /*List<Product> list = new ArrayList<>();
        list.add(new Product("1",BigDecimal.valueOf(123)));
        list.add(new Product("2",BigDecimal.valueOf(456)));
        //System.out.println(list.stream().collect(Collectors.toMap(Product::getName, Product::getPrice)));
        Stream<Locale> availableLocales = Stream.of(Locale.getAvailableLocales());
        //System.out.println(availableLocales.collect(Collectors.toMap(Locale::getDisplayLanguage, i -> i.getDisplayName(i), (oldValue, newValue) -> oldValue)));
        Map<String, Set<String>> collect = availableLocales.collect(Collectors.toMap(Locale::getDisplayCountry, i -> Collections.singleton(i.getDisplayLanguage()), (oldValue, newValue) -> {
            Set<String> strings = new HashSet<>(oldValue);
            strings.addAll(newValue);
            return strings;
        }));
        System.out.println(collect.toString());*/

        //流的分组和分区
        /*Stream<Locale> availableLocales = Stream.of(Locale.getAvailableLocales());
        Map<String, List<Locale>> collect = availableLocales.collect(Collectors.groupingBy(Locale::getCountry));
        System.out.println(collect.size());*/
        Stream<Locale> availableLocales = Stream.of(Locale.getAvailableLocales());
        Map<Boolean, List<Locale>> en = availableLocales.collect(Collectors.partitioningBy(i -> "en".equals(i.getDisplayLanguage())));
        System.out.println(en.size());

        //流的简约操作
        /*Stream<String> stringStream = Stream.of("123", "212312312");
        Integer reduce = stringStream.reduce(0, (v1, v2) -> v1 + v2.length(), (v1, v2) -> v1 + v2);
        System.out.println(reduce);*/
        List<Product> list = new ArrayList<>();
        list.add(new Product("1",BigDecimal.valueOf(123)));
        list.add(new Product("2",BigDecimal.valueOf(456)));
        Stream<Product> stream = list.stream();
        Integer reduce = stream.map(Product::getPrice).reduce(0, (v1, v2) -> v1 + v2.intValue(), (v1, v2) -> v1 + v2);
        System.out.println(reduce);
    }
}


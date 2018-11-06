package com.qding.test.lambda;

import com.alibaba.fastjson.JSON;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestLambda2 {
    public static void main( String[] args ) {
        List<StudentTest> students = new ArrayList<StudentTest>() {
            {
                add(new StudentTest(20160001, "孔明", 20, 1,"boy", "土木工程", "武汉大学"));
                add(new StudentTest(20160002, "伯约", 21, 2, "boy","信息安全", "武汉大学"));
                add(new StudentTest(20160003, "玄德", 22, 3, "boy","经济管理", "武汉大学"));
                add(new StudentTest(20160004, "云长", 21, 2, "boy","信息安全", "武汉大学"));
                add(new StudentTest(20160004, "云长2", 23, 2, "boy","信息安全", "武汉大学"));
                add(new StudentTest(20161001, "翼德", 21, 2, "boy","机械与自动化", "华中科技大学"));
                add(new StudentTest(20161002, "元直", 23, 4, "girl","土木工程", "华中科技大学"));
                add(new StudentTest(20161003, "奉孝", 23, 4, "girl","计算机科学", "华中科技大学"));
                add(new StudentTest(20162001, "仲谋", 22, 3, "girl","土木工程", "浙江大学"));
                add(new StudentTest(20162002, "鲁肃", 23, 4, "girl","计算机科学", "浙江大学"));
                add(new StudentTest(20163001, "丁奉", 24, 5, "girl","土木工程", "南京大学"));
            }
        };

        List<String> names = students.stream()
                .filter(student -> "计算机科学".equals(student.getMajor()))
                .map(StudentTest::getName).collect(Collectors.toList());
        System.out.println(JSON.toJSONString(names));
        int totalAge = students.stream()
                .filter(student -> "计算机科学".equals(student.getMajor()))
                .mapToInt(StudentTest::getAge).sum();
        System.out.println(JSON.toJSONString(totalAge));

        String[] strs = {"java8", "is", "easy", "to", "use"};
        List<String[]> distinctStrs = Arrays.stream(strs)
                .map(str -> str.split(""))  // 映射成为Stream<String[]>
                .distinct()
                .collect(Collectors.toList());
        System.out.println(JSON.toJSONString(distinctStrs));

        List<String> distinctStrs2 = Arrays.stream(strs)
                .map(str -> str.split(""))  // 映射成为Stream<String[]>
                .flatMap(Arrays::stream)  // 扁平化为Stream<String>
                .distinct()
                .collect(Collectors.toList());
        System.out.println(JSON.toJSONString(distinctStrs2));

        boolean isAdult = students.stream().allMatch(student -> student.getAge() >= 18);
        System.out.println(JSON.toJSONString(isAdult));
        boolean hasWhu = students.stream().anyMatch(student -> "武汉大学".equals(student.getSchool()));
        System.out.println(JSON.toJSONString(hasWhu));
        boolean noneCs = students.stream().noneMatch(student -> "计算机科学".equals(student.getMajor()));
        System.out.println(JSON.toJSONString(noneCs));
        Optional<StudentTest> optStu = students.stream().filter(student -> "计算机科学".equals(student.getMajor())).findFirst();
        System.out.println(JSON.toJSONString(optStu));
        Optional<StudentTest> optStuddd = students.stream().filter(student -> "计算机科学".equals(student.getMajor())).findAny();
        System.out.println(JSON.toJSONString(optStuddd));
        int totalAge2 = students.stream()
                .filter(student -> "计算机科学".equals(student.getMajor()))
                .map(StudentTest::getAge)
                .reduce(0, Integer::sum);
        System.out.println(JSON.toJSONString(totalAge2));
        long count = students.stream().collect(Collectors.counting());
        // 进一步简化
        long count2 = students.stream().count();
        System.out.println(JSON.toJSONString(count+count2));
        // 求最大年龄
        Optional<StudentTest> olderStudent = students.stream().collect(Collectors.maxBy((s1, s2) -> s1.getAge() - s2.getAge()));
        // 进一步简化
        Optional<StudentTest> olderStudent2 = students.stream().collect(Collectors.maxBy(Comparator.comparing(StudentTest::getAge)));
        // 求最小年龄
        Optional<StudentTest> olderStudent3 = students.stream().collect(Collectors.minBy(Comparator.comparing(StudentTest::getAge)));
        System.out.println(JSON.toJSONString(olderStudent));
        System.out.println(JSON.toJSONString(olderStudent2));
        System.out.println(JSON.toJSONString(olderStudent3));
        int totalAge4 = students.stream().collect(Collectors.summingInt(StudentTest::getAge));
        System.out.println(JSON.toJSONString(totalAge4));
        IntSummaryStatistics statistics = students.stream().collect(Collectors.summarizingInt(StudentTest::getAge));
        System.out.println(JSON.toJSONString(statistics));
        String names2 = students.stream().map(StudentTest::getName).collect(Collectors.joining(", "));
        System.out.println(JSON.toJSONString(names2));
        Map<String, List<StudentTest>> groups = students.stream().collect(Collectors.groupingBy(StudentTest::getSchool));
        System.out.println(JSON.toJSONString(groups));
        Map<String, Map<String, List<StudentTest>>> groups2 = students.stream().collect(
                Collectors.groupingBy(StudentTest::getSchool,  // 一级分组，按学校
                        Collectors.groupingBy(StudentTest::getMajor)));  // 二级分组，按专业
        System.out.println(JSON.toJSONString(groups2));
        Map<String, Long> groups3 = students.stream().collect(Collectors.groupingBy(StudentTest::getSchool, Collectors.counting()));
        System.out.println(JSON.toJSONString(groups3));
        Map<Boolean, List<StudentTest>> partition = students.stream().collect(Collectors.partitioningBy(student -> "武汉大学".equals(student.getSchool())));
        System.out.println(JSON.toJSONString(partition));
//        testStudent();
//        System.out.println(JSON.toJSONString(obj3));
        //{"数学":[94.0],"语文":[91.0,90.0],"英语":[92.0]}
//        testAllLamba();
//        testCollection();
    }

    private static void testStudent() {
        Subject subject1 = new Subject(1, "语文", 91.0);
        Subject subject2 = new Subject(2, "数学", 94.0);
        Subject subject3 = new Subject(3, "英语", 92.0);
        Subject subject4 = new Subject(4, "语文", 90.0);
        List<Subject> subjectList = new ArrayList<>();
        subjectList.add(subject1);
        subjectList.add(subject2);
        subjectList.add(subject3);
        subjectList.add(subject4);

        //按某个条件统计，key的某个属性的列表
        Map<String, List<Double>> stringListMap4 = subjectList.stream().collect(Collectors.groupingBy(Subject::getName,
                Collectors.mapping(Subject::getGrade, Collectors.toList())));

        Map<String, Long> stringListMap4Long = subjectList.stream().collect(Collectors.groupingBy(Subject::getName,
                Collectors.counting()));

        Object obj=subjectList.stream().collect(Collectors.groupingBy(Subject::getName,Collectors.mapping(Subject::getGrade,Collectors.toList())));
        Object obj2 =subjectList.stream().collect(Collectors.groupingBy(Subject::getName,Collectors.mapping(Subject::getGrade,Collectors.toList())));
//        Object obj3 =subjectList.stream().collect(Collectors.groupingBy(Subject::getName,);

        System.out.println(JSON.toJSONString(stringListMap4Long));
        System.out.println(JSON.toJSONString(stringListMap4));
        System.out.println(JSON.toJSONString(obj));
        System.out.println(JSON.toJSONString(obj2));
    }

    private static void testAllLamba() {
        // 将Stream转换成List或Set
        Stream<String> stream = Stream.of("I", "love", "you", "you", "too");
        List<String> stringList = stream.collect(Collectors.toList()); // (1)
        System.out.println(JSON.toJSONString(stringList));//["I","love","you","you","too"]

//        Set<String> set = stream.collect(Collectors.toSet()); // (2)
//        System.out.println(JSON.toJSONString(set));//["love","too","I","you"]

        //返回的是一个String，不是List<String>
        String string1 = stringList.stream().collect(Collectors.joining());
        System.out.println(string1);//Iloveyouyoutoo


        String string2 = stringList.stream().collect(Collectors.joining(","));
        System.out.println(string2);//I,love,you,you,too

//        public static Collector<CharSequence, ?, String> joining(CharSequence delimiter,
//                CharSequence prefix,
//                CharSequence suffix) {
        String string3 = stringList.stream().collect(Collectors.joining(",", "{", "}"));
        System.out.println(string3);//{I,love,you,you,too}

        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("C");
        Set<String> stringSet = list.stream().collect(Collectors.toSet());
        System.out.println(JSON.toJSONString(stringSet));//["A","B","C"]

        //------------------------------------------------------------------------
        Subject subject1 = new Subject(1, "语文", 91.0);
        Subject subject2 = new Subject(2, "数学", 94.0);
        Subject subject3 = new Subject(3, "英语", 92.0);
        Subject subject4 = new Subject(4, "语文", 90.0);
        List<Subject> subjectList = new ArrayList<>();
        subjectList.add(subject1);
        subjectList.add(subject2);
        subjectList.add(subject3);
        subjectList.add(subject4);


        Map<Integer, String> map1 = subjectList.stream().collect(Collectors.toMap(Subject::getId, Subject::getName));
        System.out.println(JSON.toJSONString(map1));//{1:"语文",2:"数学",3:"英语",4:"语文"}

//        Map<String, Double> map2 = subjectList.stream().collect(Collectors.toMap(Subject::getName, Subject::getGrade));
//        出现重复key，报错：java.lang.IllegalStateException: Duplicate key 91.0
//        System.out.println(JSON.toJSONString(map2));

        Map<String, Double> map2 = subjectList.stream().collect(Collectors.toMap(Subject::getName, Subject::getGrade,
                (oldValue, newValue) -> newValue));//方法引用只带方法名即可，不必带圆括号
        //出现重复key则用新值覆盖
        System.out.println(JSON.toJSONString(map2));//{"数学":94.0,"语文":90.0,"英语":92.0}

        Map<String, Double> map3 = subjectList.stream().collect(Collectors.toMap(Subject::getName, Subject::getGrade,
                (oldValue, newValue) -> oldValue));
        //出现重复key继续用旧值
        System.out.println(JSON.toJSONString(map3));//{"数学":94.0,"语文":91.0,"英语":92.0}

        Map<Integer, Subject> map4 = subjectList.stream().collect(Collectors.toMap(Subject::getId,
                Function.identity(), (oldValue, newValue) -> newValue));
        System.out.println(JSON.toJSONString(map4));
        //{1:{"grade":91.0,"id":1,"name":"语文"},2:{"grade":94.0,"id":2,"name":"数学"},3:{"grade":92.0,"id":3,"name":"英语"},4:{"grade":90.0,"id":4,"name":"语文"}}

        //value是对象
        Map<String, Subject> map5 = subjectList.stream().collect(Collectors.toMap(Subject::getName,
                Function.identity(), (oldValue, newValue) -> oldValue, HashMap::new));
        System.out.println(JSON.toJSONString(map5));
        //{"数学":{"grade":94.0,"id":2,"name":"数学"},"语文":{"grade":91.0,"id":1,"name":"语文"},"英语":{"grade":92.0,"id":3,"name":"英语"}}

        //这里的key必须是boolean型
        //按照某个条件是否成立分为两组，value是list
        Map<Boolean, List<Subject>> stringListMap1 = subjectList.stream().collect(Collectors.partitioningBy(s -> s.getName().equals("语文")));
        System.out.println(JSON.toJSONString(stringListMap1));
        //{false:[{"grade":94.0,"id":2,"name":"数学"},{"grade":92.0,"id":3,"name":"英语"}],true:[{"grade":91.0,"id":1,"name":"语文"},{"grade":90.0,"id":4,"name":"语文"}]}

        //按照某个条件分为多组，value是list
        Map<String, List<Subject>> stringListMap2 = subjectList.stream().collect(Collectors.groupingBy(Subject::getName));//这里只能是Subject::getName，如果写成subject.getName()则报错
        System.out.println(JSON.toJSONString(stringListMap2));
        //{"数学":[{"grade":94.0,"id":2,"name":"数学"}],"语文":[{"grade":91.0,"id":1,"name":"语文"},{"grade":90.0,"id":4,"name":"语文"}],"英语":[{"grade":92.0,"id":3,"name":"英语"}]}

        //使用parallelStream是多管道处理，效率比stream高很多
        Map<String, List<Subject>> stringListMap5 = subjectList.parallelStream().collect(Collectors.groupingBy(Subject::getName));//这里只能是Subject::getName，如果写成subject.getName()则报错
        System.out.println(JSON.toJSONString(stringListMap5));
        //{"数学":[{"grade":94.0,"id":2,"name":"数学"}],"语文":[{"grade":91.0,"id":1,"name":"语文"},{"grade":90.0,"id":4,"name":"语文"}],"英语":[{"grade":92.0,"id":3,"name":"英语"}]}

        //按某个条件统计，每种key存在多少个总数
        Map<String, Long> stringListMap3 = subjectList.stream().collect(Collectors.groupingBy(Subject::getName, Collectors.counting()));
        System.out.println(JSON.toJSONString(stringListMap3));
        //{"数学":1,"语文":2,"英语":1}

        //按某个条件统计，key的某个属性的列表
        Map<String, List<Double>> stringListMap4 = subjectList.stream().collect(Collectors.groupingBy(Subject::getName,
                Collectors.mapping(Subject::getGrade, Collectors.toList())));
        System.out.println(JSON.toJSONString(stringListMap4));
        //{"数学":[94.0],"语文":[91.0,90.0],"英语":[92.0]}

        //------------------------------------------------------------------------
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        //串行输出
        numbers.stream().forEach(System.out::print);//123456789

        System.out.println();

        //并行输出
        numbers.parallelStream().forEach(System.out::print);//658973421

        System.out.println();

        //并行有序输出
        numbers.parallelStream().forEachOrdered(System.out::print);//123456789
    }

    private static void testCollection() {
        Integer[] dd = { 1, 2, 3 };
        Stream<Integer> stream = Arrays.stream(dd);
        stream.map(str -> Integer.toString(str)).forEach(str -> {
            System.out.println(str);// 1 ,2 ,3
             System.out.println(str.getClass());// class java.lang.String
             });
        List<Emp> list = Arrays.asList(new Emp("a"), new Emp("b"), new Emp("c"));
        list.stream().map(emp -> emp.getName()).forEach(str -> {System.out.println(str);});
        System.out.println("==========================");
        Arrays.stream(dd).map(str -> (str=str+1)).forEach( str -> System.out.println(str) );

        String[] strs = {"aaa", "bbb", "ccc"};
        Arrays.stream(strs).map(str -> str.split("")).forEach(System.out::println);// Ljava.lang.String;@53d8d10a
        Arrays.stream(strs).map(str -> str.split("")).flatMap(Arrays::stream).forEach(System.out::println);// aaabbbccc
        Arrays.stream(strs).map(str -> str.split("")).flatMap(str -> Arrays.stream(str)).forEach(System.out::println);// aaabbbccc

        System.out.println("==========================");
        System.out.println("==========================");
        System.out.println("==========================");
        List<Integer> integerList = Arrays.asList(1,2,3,4,5);
        integerList.stream()
                .flatMap(integer -> Arrays.asList(integer + "a", integer + "b").stream())
                .forEach(item -> System.out.print(item + " ") );

        integerList.stream()
                .flatMap(integer -> Arrays.asList(integer + "a", integer + "b").stream())
                .forEach(item -> System.out.print(item + " ") );
    }

    public static class Emp {		private String name; 		public Emp() {			super();		} 		public Emp(String name) {			super();			this.name = name;		} 		public String getName() {			return name;		} 		public void setName(String name) {			this.name = name;		} 	}




    public static void getMap(){
        User user1 = new User(1, "u1", "shenyang", "hahaha");
        User user2 = new User(2, "u2", "shenyang", "gaga");
        User user3 = new User(3, "u3", "shanghai", "lala");
        User user4 = new User(4, "u4", "shanghai", "hahaha");
        User user5 = new User(5, "u5", "shenyang", "gaga");
        User user6 = new User(6, "u6", "shanghai", "hahaha");
        User user7 = new User(7, "u7", "beijing", "gaga");
        User user8 = new User(8, "u8", "beijing", "hahaha");
        User user9 = new User(9, "u9", "shenyang", "lala");
        List<User> lis = new ArrayList<>();
        lis.add(user1);
        lis.add(user2);
        lis.add(user3);
        lis.add(user4);
        lis.add(user5);
        lis.add(user6);
        lis.add(user7);
        lis.add(user8);
        lis.add(user9);

        //List<User> lis1 =lis.stream().filter(a->a.getAdd().equals("shenyang")).collect(Collectors.toList());
        //lis1.forEach(a->System.out.println(UserOp.getInfo(a)));

        int numcount =lis.stream().mapToInt(a->a.getNum()).sum();
        System.out.println(numcount);

//        List<String> aa=lis.stream().map(a->a.getname(a)).collect(Collectors.toList());
//        aa.forEach(a->System.out.println(a));

    }


    private static void getLamda() {
        List<String> collected = new ArrayList<>();
        collected.add("alpha");
        collected.add("beta");
        collected = collected.stream().map(string -> string.toUpperCase()).collect(Collectors.toList());
        System.out.println(collected);

        collected = collected.stream().map(String::toUpperCase).collect(Collectors.toCollection(ArrayList::new));//注意发生的变化

        collected.stream().map(String::toUpperCase).collect(Collectors.toList());

        System.out.println(collected);


    }

    private static void gettest() {
        long[] arrayOfLong = new long [ 20000 ];

        Arrays.parallelSetAll( arrayOfLong,
                index -> ThreadLocalRandom.current().nextInt( 1000000 ) );

        Arrays.stream( arrayOfLong ).limit( 10 ).forEach(
                i -> System.out.print( i + " " ) );
        System.out.println();

        Arrays.parallelSort( arrayOfLong );
        Arrays.stream( arrayOfLong ).limit( 10 ).forEach(
                i -> System.out.print( i + " " ) );
        System.out.println();
    }
}

package com.qding.test.lambda;

import com.alibaba.fastjson.JSON;
import org.javatuples.Pair;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.function.Function.identity;

public class TestLambda {
    public static void main( String[] args ) {
        List<StudentTest> students = new ArrayList<StudentTest>() {
            {
                add(new StudentTest(20160001, "孔明", 20, 1,"boy", "土木工程", "武汉大学"));
                add(new StudentTest(20160002, "伯约", 21, 2, "boy","信息安全", "武汉大学"));
                add(new StudentTest(20160003, "玄德", 22, 3, "boy","经济管理", "武汉大学"));
                add(new StudentTest(20160004, "云长", 24, 2, "boy","信息安全", "武汉大学"));
                add(new StudentTest(20160004, "云长2", 23, 2, "boy","信息安全", "武汉大学"));
                add(new StudentTest(20161001, "翼德", 21, 2, "boy","机械与自动化", "华中科技大学"));
                add(new StudentTest(20161002, "元直", 23, 4, "girl","土木工程", "华中科技大学"));
                add(new StudentTest(20161003, "奉孝", 23, 4, "girl","计算机科学", "华中科技大学"));
                add(new StudentTest(20162001, "仲谋", 22, 3, "girl","土木工程", "浙江大学"));
                add(new StudentTest(20162002, "鲁肃", 23, 4, "girl","计算机科学", "浙江大学"));
                add(new StudentTest(20163001, "丁奉", 24, 5, "girl","土木工程", "南京大学"));
            }
        };
        //        testFuncLambada(students);
        //1.按学校分组
        Map<String,List<StudentTest>> schoolGroup =students.stream().collect(Collectors.groupingBy(StudentTest::getSchool));
        System.out.println("==============1.按学校分组===========");
        System.out.println(JSON.toJSONString(schoolGroup));
        //2.按学校、专业分组
        Map<String,Map<String,Long>> schoolMajorGroup =students.stream()
                .collect(Collectors.groupingBy(StudentTest::getSchool,Collectors.groupingBy(StudentTest::getMajor,Collectors.counting())));

        System.out.println("=============2.按学校、专业分组===========");
        System.out.println(JSON.toJSONString(schoolMajorGroup));
        //3.按学校、专业、性别分组、
        Object schoolMajorSexGroup =students.stream().filter(x -> x.getAge()>21)
                .collect(Collectors.groupingBy(StudentTest::getSchool,Collectors.groupingBy(StudentTest::getMajor)));
        System.out.println("=============3.按学校、专业、性别分组===========");
        System.out.println(JSON.toJSONString(schoolMajorSexGroup));



        System.out.println(JSON.toJSONString(schoolMajorGroup));


        Map<String, Map<String, List<StudentTest>>> groups2333 = students.stream().collect(
                Collectors.groupingBy(StudentTest::getSchool,  // 一级分组，按学校
                        Collectors.groupingBy(StudentTest::getMajor)));  // 二级分组，按专业
//        public Map<Integer, List<Double>> normalDistributeProcess(Map<Integer, List<Pair<String, Double>>> cityEnterpriseCountMap) {
//            int sigmaLength = this.getSigma();
//            return cityEnterpriseCountMap.entrySet().stream()
//                    .collect(Collectors.toMap(Map.Entry::getKey, x -> {
//                        List<Double> values = x.getValue().stream().map(Pair::getValue1).collect(Collectors.toList());
//                        double average = values.stream().mapToDouble(y -> y).average().orElse(0);
//                        double sigma = Math.sqrt(values.stream().mapToDouble(y -> Math.pow(y - average, 2)).sum() / values.size());
//                        return values.stream().filter(y -> y <= (average + sigmaLength * sigma) && y >= (average - sigmaLength * sigma)).collect(Collectors.toList());
//                    }));
//        }
        //Map<"学校"，Map<"专业"，List<"名称">>>
//        Map<String,Map<String,List<String>>> map = students.stream().collect(



        System.out.println("================================================================================================");
        List<String> names = students.stream()
                .filter(student -> "计算机科学".equals(student.getMajor()))
                .map(StudentTest::getName).collect(Collectors.toList());
        //["奉孝","鲁肃"]
        System.out.println(JSON.toJSONString(names));
        int totalAge = students.stream()
                .filter(student -> "计算机科学".equals(student.getMajor()))
                .mapToInt(StudentTest::getAge).sum();
        //46
        System.out.println(JSON.toJSONString(totalAge));

        String[] strs = {"java8", "is", "easy", "to", "use"};
        List<String[]> distinctStrs = Arrays.stream(strs)
                .map(str -> str.split(""))  // 映射成为Stream<String[]>
                .distinct()
                .collect(Collectors.toList());
        //[["j","a","v","a","8"],["i","s"],["e","a","s","y"],["t","o"],["u","s","e"]]
        System.out.println(JSON.toJSONString(distinctStrs));

        List<String> distinctStrs2 = Arrays.stream(strs)
                .map(str -> str.split(""))  // 映射成为Stream<String[]>
                .flatMap(Arrays::stream)  // 扁平化为Stream<String>
                .distinct()
                .collect(Collectors.toList());
//        ["j","a","v","8","i","s","e","y","t","o","u"]
        System.out.println(JSON.toJSONString(distinctStrs2));

        boolean isAdult = students.stream().allMatch(student -> student.getAge() >= 18);
        //true
        System.out.println(JSON.toJSONString(isAdult));
        boolean hasWhu = students.stream().anyMatch(student -> "武汉大学".equals(student.getSchool()));
        //true
        System.out.println(JSON.toJSONString(hasWhu));
        boolean noneCs = students.stream().noneMatch(student -> "计算机科学".equals(student.getMajor()));
        //false
        System.out.println(JSON.toJSONString(noneCs));
        Optional<StudentTest> optStu = students.stream().filter(student -> "计算机科学".equals(student.getMajor())).findFirst();
        //{"age":23,"grade":4,"id":20161003,"major":"计算机科学","name":"奉孝","school":"华中科技大学"}
        System.out.println(JSON.toJSONString(optStu));
        Optional<StudentTest> optStuddd = students.stream().filter(student -> "计算机科学".equals(student.getMajor())).findAny();
        //{"age":23,"grade":4,"id":20161003,"major":"计算机科学","name":"奉孝","school":"华中科技大学"}
        System.out.println(JSON.toJSONString(optStuddd));
        int totalAge2 = students.stream()
                .filter(student -> "计算机科学".equals(student.getMajor()))
                .map(StudentTest::getAge)
                .reduce(0, Integer::sum);
        //46
        System.out.println(JSON.toJSONString(totalAge2));
        long count = students.stream().collect(Collectors.counting());
        // 进一步简化
        long count2 = students.stream().count();
        //22
        System.out.println(JSON.toJSONString(count+count2));
        // 求最大年龄
        Optional<StudentTest> olderStudent = students.stream().collect(Collectors.maxBy((s1, s2) -> s1.getAge() - s2.getAge()));
        // 进一步简化
        Optional<StudentTest> olderStudent2 = students.stream().collect(Collectors.maxBy(Comparator.comparing(StudentTest::getAge)));
        // 求最小年龄
        Optional<StudentTest> olderStudent3 = students.stream().collect(Collectors.minBy(Comparator.comparing(StudentTest::getAge)));
//        {"age":24,"grade":5,"id":20163001,"major":"土木工程","name":"丁奉","school":"南京大学"}
        System.out.println(JSON.toJSONString(olderStudent));
//        {"age":24,"grade":5,"id":20163001,"major":"土木工程","name":"丁奉","school":"南京大学"}
        System.out.println(JSON.toJSONString(olderStudent2));
//        {"age":20,"grade":1,"id":20160001,"major":"土木工程","name":"孔明","school":"武汉大学"}
        System.out.println(JSON.toJSONString(olderStudent3));
        int totalAge4 = students.stream().collect(Collectors.summingInt(StudentTest::getAge));
        //243
        System.out.println(JSON.toJSONString(totalAge4));
        IntSummaryStatistics statistics = students.stream().collect(Collectors.summarizingInt(StudentTest::getAge));
        //{"average":22.09090909090909,"count":11,"max":24,"min":20,"sum":243}
        System.out.println(JSON.toJSONString(statistics));
        String names2 = students.stream().map(StudentTest::getName).collect(Collectors.joining(", "));
        //"孔明, 伯约, 玄德, 云长, 云长2, 翼德, 元直, 奉孝, 仲谋, 鲁肃, 丁奉"
        System.out.println(JSON.toJSONString(names2));
        Map<String, List<StudentTest>> groups = students.stream().collect(Collectors.groupingBy(StudentTest::getSchool));
        //{"南京大学":[{"age":24,"grade":5,"id":20163001,"major":"土木工程","name":"丁奉","school":"南京大学"}],"武汉大学":[{"age":20,"grade":1,"id":20160001,"major":"土木工程","name":"孔明","school":"武汉大学"},{"age":21,"grade":2,"id":20160002,"major":"信息安全","name":"伯约","school":"武汉大学"},{"age":22,"grade":3,"id":20160003,"major":"经济管理","name":"玄德","school":"武汉大学"},{"age":21,"grade":2,"id":20160004,"major":"信息安全","name":"云长","school":"武汉大学"},{"age":23,"grade":2,"id":20160004,"major":"信息安全","name":"云长2","school":"武汉大学"}],"浙江大学":[{"age":22,"grade":3,"id":20162001,"major":"土木工程","name":"仲谋","school":"浙江大学"},{"age":23,"grade":4,"id":20162002,"major":"计算机科学","name":"鲁肃","school":"浙江大学"}],"华中科技大学":[{"age":21,"grade":2,"id":20161001,"major":"机械与自动化","name":"翼德","school":"华中科技大学"},{"age":23,"grade":4,"id":20161002,"major":"土木工程","name":"元直","school":"华中科技大学"},{"age":23,"grade":4,"id":20161003,"major":"计算机科学","name":"奉孝","school":"华中科技大学"}]}
        System.out.println(JSON.toJSONString(groups));
        Map<String, Map<String, List<StudentTest>>> groups2 = students.stream().collect(
                Collectors.groupingBy(StudentTest::getSchool,  // 一级分组，按学校
                        Collectors.groupingBy(StudentTest::getMajor)));  // 二级分组，按专业
        //{"南京大学":{"土木工程":[{"age":24,"grade":5,"id":20163001,"major":"土木工程","name":"丁奉","school":"南京大学"}]},"武汉大学":{"土木工程":[{"age":20,"grade":1,"id":20160001,"major":"土木工程","name":"孔明","school":"武汉大学"}],"信息安全":[{"age":21,"grade":2,"id":20160002,"major":"信息安全","name":"伯约","school":"武汉大学"},{"age":21,"grade":2,"id":20160004,"major":"信息安全","name":"云长","school":"武汉大学"},{"age":23,"grade":2,"id":20160004,"major":"信息安全","name":"云长2","school":"武汉大学"}],"经济管理":[{"age":22,"grade":3,"id":20160003,"major":"经济管理","name":"玄德","school":"武汉大学"}]},"浙江大学":{"土木工程":[{"age":22,"grade":3,"id":20162001,"major":"土木工程","name":"仲谋","school":"浙江大学"}],"计算机科学":[{"age":23,"grade":4,"id":20162002,"major":"计算机科学","name":"鲁肃","school":"浙江大学"}]},"华中科技大学":{"土木工程":[{"age":23,"grade":4,"id":20161002,"major":"土木工程","name":"元直","school":"华中科技大学"}],"计算机科学":[{"age":23,"grade":4,"id":20161003,"major":"计算机科学","name":"奉孝","school":"华中科技大学"}],"机械与自动化":[{"age":21,"grade":2,"id":20161001,"major":"机械与自动化","name":"翼德","school":"华中科技大学"}]}}
        System.out.println(JSON.toJSONString(groups2));
        Map<String, Long> groups3 = students.stream().collect(Collectors.groupingBy(StudentTest::getSchool, Collectors.counting()));
        //{"南京大学":1,"武汉大学":5,"浙江大学":2,"华中科技大学":3}
        System.out.println(JSON.toJSONString(groups3));
        Map<Boolean, List<StudentTest>> partition = students.stream().collect(Collectors.partitioningBy(student -> "武汉大学".equals(student.getSchool())));
        //{false:[{"age":21,"grade":2,"id":20161001,"major":"机械与自动化","name":"翼德","school":"华中科技大学"},{"age":23,"grade":4,"id":20161002,"major":"土木工程","name":"元直","school":"华中科技大学"},{"age":23,"grade":4,"id":20161003,"major":"计算机科学","name":"奉孝","school":"华中科技大学"},{"age":22,"grade":3,"id":20162001,"major":"土木工程","name":"仲谋","school":"浙江大学"},{"age":23,"grade":4,"id":20162002,"major":"计算机科学","name":"鲁肃","school":"浙江大学"},{"age":24,"grade":5,"id":20163001,"major":"土木工程","name":"丁奉","school":"南京大学"}],true:[{"age":20,"grade":1,"id":20160001,"major":"土木工程","name":"孔明","school":"武汉大学"},{"age":21,"grade":2,"id":20160002,"major":"信息安全","name":"伯约","school":"武汉大学"},{"age":22,"grade":3,"id":20160003,"major":"经济管理","name":"玄德","school":"武汉大学"},{"age":21,"grade":2,"id":20160004,"major":"信息安全","name":"云长","school":"武汉大学"},{"age":23,"grade":2,"id":20160004,"major":"信息安全","name":"云长2","school":"武汉大学"}]}
        System.out.println(JSON.toJSONString(partition));
    }

    private static void testFuncLambada(List<StudentTest> students) {
        Object map = students.stream().collect(
                Collectors.groupingBy(StudentTest::getSchool,
                        Collectors.groupingBy(StudentTest::getMajor,Collectors.counting()
                        ))
               );
        System.out.println(JSON.toJSONString(map));
        map = students.stream().collect(
                Collectors.groupingBy(StudentTest::getSchool,
                        Collectors.groupingBy(StudentTest::getMajor,Collectors.mapping(StudentTest::getName,Collectors.toList())
                        ))
        );

        System.out.println(JSON.toJSONString(map));
        map = students.stream().collect(
                Collectors.groupingBy(StudentTest::getSchool,
                        Collectors.groupingBy(StudentTest::getMajor,Collectors.toMap(StudentTest::getName,ss ->ss.getAge()))
                        )
        );

        System.out.println(JSON.toJSONString(map));

        Map<String, Map<String,Integer>> ttMap=
         students.stream().collect(
                Collectors.groupingBy(StudentTest::getSchool,
                        Collectors.groupingBy(StudentTest::getMajor,
                                Collectors.summingInt(StudentTest::getAge)))
        );

        System.out.println(JSON.toJSONString(ttMap));

    }

}

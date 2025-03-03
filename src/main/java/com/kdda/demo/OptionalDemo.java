package com.kdda.demo;

import java.util.Optional;

public class OptionalDemo {
    public static void main(String[] args) {
        // 1. 创建 Optional 对象
        Optional<String> optionalWithValue = Optional.of("Hello, World!");
        Optional<String> optionalEmpty = Optional.empty();
        Optional<String> optionalNullable = Optional.ofNullable(null); // Optional.empty()

        // 2. 检查是否有值
        System.out.println(optionalWithValue.isPresent()); // true
        System.out.println(optionalEmpty.isPresent()); // false

        // 3. 获取值
        System.out.println(optionalWithValue.get()); // Hello, World!
        System.out.println(optionalEmpty.orElse("Default Value")); // Default Value

        // 4. 使用 orElseGet
        String result = optionalEmpty.orElseGet(() -> "Generated Value");
        System.out.println(result); // Generated Value

        // 5. 使用 ifPresent
        optionalWithValue.ifPresent(value -> System.out.println("Value: " + value)); // Value: Hello, World!

        // 6. 使用 map 处理值
        Optional<String> upperCaseValue = optionalWithValue.map(String::toUpperCase);
        System.out.println(upperCaseValue.orElse("No Value")); // HELLO, WORLD!

        // 7. 使用 flatMap
        Optional<Optional<String>> nestedOptional = Optional.of(Optional.of("Nested Value"));
        Optional<String> flatMappedValue = nestedOptional.flatMap(opt -> opt);
        System.out.println(flatMappedValue.get()); // Nested Value

        // 8. 使用 filter 过滤值
        Optional<String> filteredValue = optionalWithValue.filter(val -> val.contains("World"));
        System.out.println(filteredValue.orElse("Filtered Out")); // Hello, World!
    }
}

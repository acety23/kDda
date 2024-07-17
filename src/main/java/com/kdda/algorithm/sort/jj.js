function validatePhoneNumber(phoneNumber) {
    // 匹配中国大陆手机号码格式（11位数字，以1开头）
    const pattern = /^1[3-9]\d{9}$/;
    return pattern.test(phoneNumber);
}

// 测试
console.log(validatePhoneNumber("13812345678")); // true
console.log(validatePhoneNumber("12345678900")); // false

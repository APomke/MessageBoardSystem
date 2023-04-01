// 发送验证码函数
function sendVerificationCode() {
    // 获取页面中的元素
    var emailInput = document.getElementById('email');
    var sendButton = document.getElementById('send-button');
    var countdown = document.getElementById('countdown');

    // 验证邮箱地址是否有效函数
    function validateEmail(email) {
        var re = /\S+@\S+\.\S+/;
        return re.test(email);
    }

    // 验证邮箱地址是否有效
    if (!validateEmail(emailInput.value)) {
        alert('请输入有效的邮箱地址');
        return;
    }

    // 生成验证码函数
    function generateVerificationCode() {
        // 生成随机验证码
        var code = '';
        var possible = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789';
        for (var i = 0; i < 6; i++) {
            code += possible.charAt(Math.floor(Math.random() * possible.length));
        }
        return code;
    }

    // 生成验证码
    verificationCode = generateVerificationCode();

    // 发送验证码到后端
    var xhr = new XMLHttpRequest();
    xhr.open('POST', '/sendVerificationCode');
    xhr.setRequestHeader('Content-Type', 'application/json;charset=UTF-8');
    xhr.send(JSON.stringify({email: emailInput.value, code: verificationCode}));
    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4 && xhr.status == 200) {
            alert('验证码已发送至您的邮箱，请查收。');
        }
    };

    // 禁用发送按钮，启动计时器
    sendButton.disabled = true;
    countdown.innerHTML = '60 秒后可再次发送';
    var remainingSeconds = 60;
    var countdownTimer = setInterval(function() {
        remainingSeconds--;
        countdown.innerHTML = remainingSeconds + ' 秒后可再次发送';
        if (remainingSeconds == 0) {
            clearInterval(countdownTimer);
            sendButton.disabled = false;
            countdown.innerHTML = '';
        }
    }, 1000);

    // 激活验证码输入框和提交按钮
    var verificationCodeInput = document.getElementById('verification-code');
    var verifyButton = document.getElementById('verify-button');
    verificationCodeInput.disabled = false;
    verifyButton.disabled = false;


}

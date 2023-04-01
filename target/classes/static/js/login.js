// 随机生成验证码字符串
function generateCaptcha() {
    const chars = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ';
    let captcha = '';
    for (let i = 0; i < 4; i++) {
        captcha += chars[Math.floor(Math.random() * chars.length)];
    }
    return captcha;
}

// 在 canvas 上绘制验证码图像
function drawCaptcha(canvas, captcha) {
    const ctx = canvas.getContext('2d');
    ctx.clearRect(0, 0, canvas.width, canvas.height);
    ctx.font = 'bold 20px Arial';
    ctx.textAlign = 'center';
    ctx.textBaseline = 'middle';
    ctx.fillStyle = '#0080ff';
    ctx.fillText(captcha, canvas.width / 2, canvas.height / 2);
}

// 初始化页面
function init() {
    const canvas = document.getElementById('captcha-canvas');
    const captchaInput = document.getElementById('captcha');
    const captcha = generateCaptcha();
    drawCaptcha(canvas, captcha);

    // 当用户输入验证码时验证它是否正确
    captchaInput.addEventListener('input', () => {
        if (captchaInput.value.toLowerCase() === captcha.toLowerCase()) {
            captchaInput.setCustomValidity('');
        } else {
            captchaInput.setCustomValidity('验证码错误');
        }
    });

    // 当用户点击验证码图片时更新验证码
    canvas.addEventListener('click', () => {
        const newCaptcha = generateCaptcha();
        drawCaptcha(canvas, newCaptcha);
        captchaInput.value = '';
        captchaInput.setCustomValidity('');
        captcha = newCaptcha;
    });
}

init();

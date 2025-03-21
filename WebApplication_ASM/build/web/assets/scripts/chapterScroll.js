let lastScrollTop = 0;
const scrollNav = document.getElementById("scrollNav");

window.addEventListener("scroll", function () {
    const st = window.pageYOffset || document.documentElement.scrollTop;
    if (st < lastScrollTop) {
        scrollNav.style.bottom = "0";
    } else {
        scrollNav.style.bottom = "-60px";
    }
    lastScrollTop = st <= 0 ? 0 : st;
}, false);
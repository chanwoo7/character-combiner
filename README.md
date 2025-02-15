# 글자 조합기 for Kkutu Korea

## 📋 글자 조각 목록 복사 코드

- 프로필 화면에서 '프로필 관리' 버튼을 누른 후, 개발자 도구를 열고 콘솔 탭에서 아래의 코드를 입력한다.
```JavaScript
copy([...document.querySelector("#dress-goods").children]
    .filter(el => el.id && el.id.startsWith("dress-$WP"))
    .map(el => {
        let firstChild = el.children[0];
        return firstChild ? `${el.id.replace("dress-$WP", "")}${firstChild.textContent.trim()}` : null;
    })
    .filter(Boolean)
    .join(","));
```
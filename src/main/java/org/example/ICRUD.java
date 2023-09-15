package org.example;

public interface ICRUD { //인터페이스를 통해서 자주 사용하는 함수들의 템플릿을 만들고 오버라이드해놨는데 실제로 사용하진 않음.

    public Object add();
    public int update(Object obj); //얘네는 사용안함. 사용할줄 알고 만들었지만 안함. 초보자라 그럼.
    public int delete(Object obj);
    public void selectOne(int id);
}

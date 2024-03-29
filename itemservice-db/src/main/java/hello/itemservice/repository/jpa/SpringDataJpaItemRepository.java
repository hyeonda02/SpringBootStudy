package hello.itemservice.repository.jpa;

import hello.itemservice.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * JpaRepository 인터페이스를 상속받고, 제네릭에 관리할 <엔티티, 엔티티Id>를 주면 된다. ( 여기서 아이디 값이 Long 타입이다. )
 * 그러면 JpaRepository가 제공하는 기본 CRUD 기능을 모두 사용할 수 있다.
 * JpaRepository 인터페이스만 상속받으면 스프링 데이터 JPA가 프록시 기술을 사용해서 구현 클래스를 만들어준다. 그리고 만든 구현 클래스의
 * 인스턴스를 만들어서 스프링빈으로 등록한다.
 * 따라서 개발자는 구현 클래스 없이 인터페이스만 만들면 기본 CRUD 기능을 사용할 수 있다.
 *
 *
 * 그런데 이름으로 검색하거나, 가격으로 검색하는 기능은 공통으로 제공할 수 있는 기능이 아니다.
 * 따라서 쿼리 메서드 기능을 사용하거나 @Query를 사용해서 직접 쿼리를 실행하면 된다.
 */


/**
 * 모든 데이터 조회
 * 이름 조회
 * 가격 조회
 * 이름 + 가격 조회
 */
public interface SpringDataJpaItemRepository extends JpaRepository<Item, Long> {
    //이름 조건만 검색했을때 사용되는 쿼리 메서드
    //select i from Item i where i.name like ?
    List<Item> findByItemNameLike(String itemName);
    List<Item> findByPriceLessThanEqual(Integer itemName);

    //쿼리 메서드 (아래 메서드와 같은 기능 수행) 두개 같이 조회하는 것
    List<Item> findByItemNameLikeAndPriceLessThanEqual(String itemName, Integer price);
    //쿼리 직접 실행
    @Query("select i from Item i where i.itemName like :itemName and i.price <= :price")
            List<Item> findItems(@Param("itemName") String itemName, @Param("price")Integer price);
}

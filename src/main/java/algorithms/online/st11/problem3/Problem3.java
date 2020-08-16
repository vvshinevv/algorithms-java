package algorithms.online.st11.problem3;

/**
 * https://stackoverflow.com/questions/36953003/left-join-count-sum-on-mysql
 *
 * 이것과 비슷하였음...
 *
 * SELECT p.*,
 *   SUM(CASE WHEN f.food in ('apple','orange') THEN f.units ELSE 0 END) as orapple,
 *   COUNT(f.category='fruit'  OR NULL) AS fruits,
 *   COUNT(f.category='fast'   OR NULL) AS fast,
 *   COUNT(f.category='cereal' OR NULL) AS cereal
 * FROM people p
 * LEFT JOIN foods f
 * ON f.person_id = p.id
 * WHERE p.id = 1
 * GROUP BY p.id;
 *
 */
public class Problem3 {

    public static void main(String[] args) {
        // left join query
    }
}

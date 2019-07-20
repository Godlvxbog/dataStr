package pattern.template;


import pattern.template.dao.MemberDao;

/**
 * Created by Tom on 2018/3/11.
 *
 * 流程是固定的，流程不可变，比如
 * check入参，幂等校验，查询费率，计价，生成账单，核销
 * reids模板、事务模板，
 */
public class MemberDaoTest {

    public static void main(String[] args) {

        MemberDao memberDao = new MemberDao();
        memberDao.query();

    }
}

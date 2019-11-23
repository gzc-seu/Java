package Team.service;

import Team.domain.Architect;
import Team.domain.Designer;
import Team.domain.Employee;
import Team.domain.Programmer;

public class TeamService {
    private static int counter=1;//用于自动生成团队成员的memberId
    private final int MAX_MEMBER = 5;//团队人数上限
    private Programmer[] team = new Programmer[MAX_MEMBER];//保存当前团队成员
    private int total = 0;//团队实际人数

    public TeamService() {
    }
    //返回team中所有程序员构成的数组
    public Programmer[] getTeam(){
        Programmer[] team=new Programmer[total];  //避免造成空指针
        for(int i=0;i<total;i++){
            team[i]=this.team[i];
        }
        return team;
    }
    /*失败信息包含以下几种：
    成员已满，无法添加
    该成员不是开发人员，无法添加
    该员工已在本开发团队中
    该员工已是某团队成员
    该员正在休假，无法添加
    团队中至多只能有一名架构师
    团队中至多只能有两名设计师
    团队中至多只能有三名程序员*/
    public void addMember(Employee e) throws TeamException{
        if(total>=MAX_MEMBER){
            throw new TeamException("成员已满，无法添加");
        }
        if(!(e instanceof Programmer)){
            throw new TeamException("该成员不是开发人员，无法添加");
        }
        if(isExist(e)){
            throw new TeamException("该员工已在本开发团队中");
        }
        Programmer p=(Programmer)e;
        if("BUSY".equals(p.getStatus().getNAME())){
            throw new TeamException("该员工已是某团队成员");
        }else if("VOCATION".equals(p.getStatus().getNAME())){
            throw new TeamException("该员正在休假，无法添加");
        }
        int num_architect=0,num_designer=0,num_programmer=0;
        for(int i=0;i<total;i++){
            if(team[i] instanceof Architect) num_architect++;
            else if(team[i] instanceof Designer) num_designer++;
            else if(team[i] instanceof Programmer) num_programmer++;
        }
        if(p instanceof Architect){
            if(num_architect>=1) throw new TeamException("团队中至多只能有一名架构师");
        }else if(p instanceof  Designer){
            if(num_designer>=2) throw new TeamException("团队中至多只能有两名设计师");
        } else if (p instanceof Programmer){
            if(num_programmer>=3) throw new TeamException("团队中至多只能有三名程序员");
        }
        p.setStatus(Status.BUSY);
        p.setMemberId(counter++);
        team[total++]=p;
    }

    private boolean isExist(Employee e) {
        for(int i=0;i<total;i++){
            if(e.getId()==team[i].getId()) return true;
        }
        return false;
    }

    public void removeMember(int memberId) throws TeamException{
        int i=0;
        for(;i<total;i++){
            if(team[i].getMemberId()==memberId){
                team[i].setStatus(Status.FREE);
                break;
            }
        }
        //如果遍历一遍，都找不到，则报异常
        if (i == total)
            throw new TeamException("找不到该成员，无法删除");
        //后面的元素覆盖前面的元素
        for(int j=i+1;j<total;j++){
            team[j-1]=team[j];
        }
        team[--total] = null;
    }
}

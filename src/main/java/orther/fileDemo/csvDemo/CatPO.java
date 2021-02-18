package orther.fileDemo.csvDemo;

/**
 * @author qin
 * @date 2020-06-12
 */
public class CatPO {
    private Integer id;
    private String name;
    private Integer gender;
    private Integer year;
    private Integer sterilization;
    private String temperament;
    private String appearance;
    private String experience;
    private String situation;
    private String advice;
    private String link;

    public void printCat(){
        System.out.println("("+id+",'"+name+"',"+gender+","+year+","+ sterilization +",'"+
                temperament+"','"+ appearance +"','"+ experience +"','"+ situation +"','"+ advice +"','"+ link +"'),");
    }
//(
// 1,
// 'Cookie',
// 0,
// 2018,
// 1,
// '恬不知耻型，偏欠打','狸花色，胸前是白色，鼻梁有一道白，后腿先天畸形有些弯，体型中等',
// '是三花花的一窝孩子的其中之一，被志愿者捡到救助站喂养，在救助站长大，同一窝的其他孩子都散布天涯，只有他安心守着救助站，冬天与一只小橘恩爱缠绵，后来小橘不见了，它也出走四栋，成为了一只差不多的普通猫','从四栋门口进到了四栋里面，在寝室徘徊，而且脾气开始有些暴躁，偶尔会打人',
// '建议先试探感情，之前它脾气很好，是个拖拉机，近些日子在外不知性情如何，总体来说亲人给撸',
// 'https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=1529807228,3826684094&fm=26&gp=0.jpg'
// )
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getSterilization() {
        return sterilization;
    }

    public void setSterilization(Integer sterilization) {
        this.sterilization = sterilization;
    }

    public String getTemperament() {
        return temperament;
    }

    public void setTemperament(String temperament) {
        this.temperament = temperament;
    }

    public String getAppearance() {
        return appearance;
    }

    public void setAppearance(String appearance) {
        this.appearance = appearance;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getSituation() {
        return situation;
    }

    public void setSituation(String situation) {
        this.situation = situation;
    }

    public String getAdvice() {
        return advice;
    }

    public void setAdvice(String advice) {
        this.advice = advice;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}

package pattern.factory.demo;

/**
 * 变量
 * 构造方法
 * get&&set
 * getByCode
 */
public enum MilkTypeEnum {
    MN("MN","MN"),
    SL("SL","Sl"),
    TLS("TLS","TLS"),
    YL("YL","YL"),

    ;
    private String name;
    private String desc;

    public static MilkTypeEnum getByCode(String name){
        for (MilkTypeEnum milkTypeEnum : values()){
            if (name.equals(milkTypeEnum.getName())){
                return milkTypeEnum;
            }
        }
        return null;
    }


    MilkTypeEnum(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}

package mybatis.domain;

public class TBMemu {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_menu.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_menu.menuName
     *
     * @mbg.generated
     */
    private String menuname;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_menu.hint
     *
     * @mbg.generated
     */
    private String hint;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_menu.order
     *
     * @mbg.generated
     */
    private Byte order;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_menu.id
     *
     * @return the value of t_menu.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_menu.id
     *
     * @param id the value for t_menu.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_menu.menuName
     *
     * @return the value of t_menu.menuName
     *
     * @mbg.generated
     */
    public String getMenuname() {
        return menuname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_menu.menuName
     *
     * @param menuname the value for t_menu.menuName
     *
     * @mbg.generated
     */
    public void setMenuname(String menuname) {
        this.menuname = menuname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_menu.hint
     *
     * @return the value of t_menu.hint
     *
     * @mbg.generated
     */
    public String getHint() {
        return hint;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_menu.hint
     *
     * @param hint the value for t_menu.hint
     *
     * @mbg.generated
     */
    public void setHint(String hint) {
        this.hint = hint;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_menu.order
     *
     * @return the value of t_menu.order
     *
     * @mbg.generated
     */
    public Byte getOrder() {
        return order;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_menu.order
     *
     * @param order the value for t_menu.order
     *
     * @mbg.generated
     */
    public void setOrder(Byte order) {
        this.order = order;
    }
}
package com.hyf.stockcircle.data.entity;

import java.util.List;

/**
 * <pre>
 *   author  : syk
 *   e-mail  : shenyukun1024@gmail.com
 *   time    : 2017/12/08 12:35
 *   desc    : 登录实体类
 *   version :1.0
 * </pre>
 */

public class UserBean extends BaseBean {
    /**
     * 地址
     */
    private String address;
    /**
     * 股友圈背景图
     */
    private String circlePicture;
    /**
     * 创建日期
     */
    private long createDate;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 唯一ID
     */
    private int id;
    /**
     * 头像
     */
    private String image;
    /**
     * 邀请码
     */
    private String inventNumber;
    /**
     * 是否可以签到
     */
    private boolean isSign;
    /**
     * 等级
     */
    private int level;
    /**
     * 股友号
     */
    private String memberNo;
    /**
     * 个人简介
     */
    private String memo;
    /**
     * 手机号
     */
    private String mobile;
    /**
     * 修改日期
     */
    private long modifyDate;
    /**
     * 用户姓名
     */
    private String name;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 排序
     */
    private int order;
    /**
     * 积分
     */
    private int point;
    /**
     * QQ号
     */
    private String qq;
    /**
     * 地区
     */
    private Region region;
    /**
     * 性别
     */
    private String sex;
    /**
     * 连续签到次数
     */
    private int signCount;
    /**
     * 最近签到时间
     */
    private long signDate;
    /**
     * 唯一标识
     */
    private String token;
    /**
     * 用户名
     */
    private String username;
    /**
     * 认证状态
     */
    private String validatorStatus;
    /**
     * 微信号
     */
    private String weichat;
    /**
     * 邮编
     */
    private String zip;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCirclePicture() {
        return circlePicture;
    }

    public void setCirclePicture(String circlePicture) {
        this.circlePicture = circlePicture;
    }

    public long getCreateDate() {
        return createDate;
    }

    public void setCreateDate(long createDate) {
        this.createDate = createDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getInventNumber() {
        return inventNumber;
    }

    public void setInventNumber(String inventNumber) {
        this.inventNumber = inventNumber;
    }

    public boolean isSign() {
        return isSign;
    }

    public void setSign(boolean sign) {
        isSign = sign;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(String memberNo) {
        this.memberNo = memberNo;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public long getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(long modifyDate) {
        this.modifyDate = modifyDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getSignCount() {
        return signCount;
    }

    public void setSignCount(int signCount) {
        this.signCount = signCount;
    }

    public long getSignDate() {
        return signDate;
    }

    public void setSignDate(long signDate) {
        this.signDate = signDate;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getValidatorStatus() {
        return validatorStatus;
    }

    public void setValidatorStatus(String validatorStatus) {
        this.validatorStatus = validatorStatus;
    }

    public String getWeichat() {
        return weichat;
    }

    public void setWeichat(String weichat) {
        this.weichat = weichat;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public class Region{
        /**
         * 子级
         */
        private List<Region> children;
        /**
         * 创建日期
         */
        private long createDate;
        /**
         * 全称
         */
        private String fullName;
        /**
         * 唯一ID
         */
        private int id;
        /**
         * 修改日期
         */
        private long modifyDate;
        /**
         * 名称
         */
        private String name;
        /**
         * 排序
         */
        private int order;
        /**
         * 上级
         */
        private Region parent;
        /**
         * 类型
         */
        private String type;

        public List<Region> getChildren() {
            return children;
        }

        public void setChildren(List<Region> children) {
            this.children = children;
        }

        public long getCreateDate() {
            return createDate;
        }

        public void setCreateDate(long createDate) {
            this.createDate = createDate;
        }

        public String getFullName() {
            return fullName;
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public long getModifyDate() {
            return modifyDate;
        }

        public void setModifyDate(long modifyDate) {
            this.modifyDate = modifyDate;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getOrder() {
            return order;
        }

        public void setOrder(int order) {
            this.order = order;
        }

        public Region getParent() {
            return parent;
        }

        public void setParent(Region parent) {
            this.parent = parent;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }
}

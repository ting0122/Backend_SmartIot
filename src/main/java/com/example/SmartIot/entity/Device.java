package com.example.SmartIot.entity;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import java.time.LocalDateTime;



//該實體映射到名為 device 的資料表
@Entity
@Table(name = "device")
//這個註解告訴 Jackson（用於將 Java 對象轉換為 JSON 的庫）在序列化或反序列化 JSON 時忽略指定的屬性。
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Device {
    
    // 主鍵
    @Id
    // 主鍵自動增長
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String type;
    private Boolean status = false;
    private Timestamp time = Timestamp.valueOf(LocalDateTime.now());

    // 多個設備對應到一個房間(等到您實際訪問 room 屬性時才加載room實體)
    @ManyToOne(fetch = FetchType.LAZY)
    // 外鍵設置為 room_id
    @JoinColumn(name = "room_id")
    //序列化時，Device 不會序列化其 room 屬性，從而避免無限遞迴
    @JsonBackReference
    private Room room;

    //讓搜尋房間時 能同步撈回設備各項參數的值
    @OneToOne(mappedBy = "device", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = true)
    @JsonManagedReference
    //這個註解告訴 Jackson 在序列化為 JSON 時，只包含非 null 的屬性。
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private AirConditioner airConditioner;

    @OneToOne(mappedBy = "device", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = true)
    @JsonManagedReference
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private AirPurifier airPurifier;

    @OneToOne(mappedBy = "device", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = true)
    @JsonManagedReference
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Dehumidifier dehumidifier;

    @OneToOne(mappedBy = "device", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = true)
    @JsonManagedReference
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Light light;


    //constructor
    public Device() {

    }


    public Device(Long id, String name, String type, Boolean status, Timestamp time, Room room) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.status = status;
        this.time = time;
        this.room = room;
    }

    //@PrePersist 註解的方法會在新實體被持久化到數據庫之前被調用。
    //@PreUpdate 註解的方法會在現有實體被更新到數據庫之前被調用。
    @PrePersist
    @PreUpdate
    private void ensureDefaults() {
        //預設設備為關閉
        if (this.status == null) {
            this.status = false;
        }
        //如果沒有時間 預設為當前時間
        if (this.time == null) {
            this.time = Timestamp.valueOf(LocalDateTime.now());
        }
    }

    //getters and setters
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean isStatus() {
        return this.status;
    }

    public Boolean getStatus() {
        return this.status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Timestamp getTime() {
        return this.time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public Room getRoom() {
        return this.room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

}

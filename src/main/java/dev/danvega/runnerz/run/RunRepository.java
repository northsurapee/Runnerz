package dev.danvega.runnerz.run;

import java.util.List;
import java.util.Optional;

/*
    Data Layer - Interact with database
    Repository pattern คือ การวางโครงสร้างของโค้ดรูปแบบหนึ่งเพื่อใช้แยก logic สำหรับการเข้าถึงแหล่งข้อมูล (data source)
    ออกจาก Business layer โดยที่มี Repository Interface ทำหน้าที่เป็นตัวกลางในการติดต่อระหว่าง Business layer
    กับ Data source โดยจะดึงข้อมูลจาก Data source แล้วแปลงข้อมูลให้อยู่ในรูปที่ทางฝั่ง Business layer สามารถนำไปใช้งานได้ทันที
    ในทางกลับกันก็สามารถที่จะรับข้อมูลจากฝั่ง Business layer เพื่อนำไปบันทึกลง Data source ได้ด้วย ซึ่งการทำ Repository pattern
    นี้ทำให้ Business layer ไม่จำเป็นต้องรู้ว่าข้อมูลที่ได้นั้น มาจาก Data source ไหนหรือจะนำไปบันทึกไว้ที่ใด ทำให้เราสามารถสับเปลี่ยน
    Data source ได้โดยที่ไม่กระทบกับทางฝั่ง Business layer อีกทั้งยังช่วยแยก Logic ที่ซับซ้อนในการเข้าถึงแหล่งข้อมูลออกจาก
    Business layer ลดการเกิด dependencies ระหว่างโค้ด ทำให้ Business layer มีเฉพาะ Business logic
*/

// We don't need to write code if we use Spring Data ( Include spring data jdbc in .pom and extends ListCrudRepository to this interface), Spring will turn interface to implementation at runtime

public interface RunRepository {

    List<Run> findAll();

    Optional<Run> findById(Integer id);

    void create(Run run);

    void update(Run run, Integer id);

    void delete(Integer id);

    int count();

    void saveAll(List<Run> runs);

    List<Run> findByLocation(String location);
}

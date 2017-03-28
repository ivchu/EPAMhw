```
class MedicalStaff{}
class Doctor extends MedicalStaff{}
class Nurse extends MedicalStaff{}
class HeadDoctor extends Doctor{}
```

||correct|not correct|Comment|
|---------|:--------:|:---------:|----|
|`Doctor doctor1 = new Doctor();`|X|||
|`Doctor doctor2 = new MedicalStaff();`||X||
|`Doctor doctor3 = new HeadDoctor();`|X|||
|`Object object1 = new HeadDoctor();`|X|||
|`HeadDoctor doctor5 = new Object();`||X||
|`Doctor doctor6  = new Nurse();`||X||
|`Nurse nurse = new Doctor();`||X||
|`Object object2 = new Nurse();`|X|||
|||||
|`List<Doctor> list1= new ArrayList<Doctor>();`|X||Тип Generic в коллекции, должен совпадать|
|`List<MedicalStaff> list2 = new ArrayList<Doctor>();`||X|Можно использовать Genric вида, <? extends MedicalStaff>|
|`List<Doctor> list3 = new ArrayList<MedicalStaff>();`||X|Можно использовать Genric вида <? super Doctor>|
|`List<Object> list4 = new ArrayList<Doctor>();`||X|Можно использовать Genric вида, <? extends Object>|
|`List<Object> list5 = new ArrayList<Object>();`|X|||


功能说明：
	gson的工具包
		core:提供一个GsonUtil工具类，该类提供从bean转成json字符串的方法（并且可以根据需要指定需要排除或者转换的属性列表）
		filter：该目录下所有的类均为ExclusionStrategy的实现子类，用来在转换时排除或者指定某些属性


依赖：gson-2.2.4.jar


使用说明：
	Person person=new Person();
	person.setAge(10);
	person.setName("miles");
	person.setId(2);
	
	System.out.println(GsonUtil.toJsonExclude(person));//将person对象的全部属性转换成json字符串
	
	System.out.println(GsonUtil.toJsonExclude(person,"name","age","a"));//将person对象中除name/age/a属性外的所有属性转换成json字符串
	
	System.out.println(GsonUtil.toJsonInclude(person));//将person对象的全部属性转换成json字符串
	
	System.out.println(GsonUtil.toJsonInclude(person,"name","a"));//将person对象中name/a属性换成json字符串
	
	
版本：	
	0.0.1-SHAPSHOT:
		简要说明：实现gson工具包的基础功能
		更新明细：
		
	0.0.2-SHAPSHOT：
		简要说明：新增说明
		更新明细：新增readme.md	
	
	
	
	
	
	
	
	
	
	

	
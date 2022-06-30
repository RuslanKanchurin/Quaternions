package quaternions;
/**
 * Класс представляет кватернионы и операцию для поворота пространства с помощью кватернионов
 * @author Ruslan Kanchurin
 *  
 */
public class Quaternion {
	/**	 Скалярная часть */
	public double s;
	/**	 Векторная часть */
	public double x;
	/**	 Векторная часть */
	public double y;
	/**	 Векторная часть */
	public double z;
	
	/**
	 * Конструктор - задание всех четырех параметров
	 * @param s Скалярная часть
	 * @param x Векторная часть
	 * @param y Векторная часть
	 * @param z Векторная часть
	 */
	public Quaternion(double s, double x,double y, double z) {
		this.s=s;
		this.x=x;
		this.y=y;
		this.z=z;
	}
	/**
	 * Конструктор - задание разных параметров для скалярной и векторной частей
	 * @param s Скалярная часть
	 * @param v Векторная часть
	 */
	public Quaternion(double s, double v) {
		this.s=s;
		this.x=v;
		this.y=v;
		this.z=v;
	}
	/**
	 * Конструктор - кватернион с нулевыми параметрами
	 */
	public Quaternion() {
		this.s=0;
		this.x=0;
		this.y=0;
		this.z=0;
	}
	/**
	 * Конструктор - создание кватерниона с помощью другого кватерниона
	 * @param b Кватернион
	 */
	public Quaternion(Quaternion b) {
		this.s=b.s;
		this.x=b.x;
		this.y=b.y;
		this.z=b.z;
	}
	/**
	 * Перевод в формат строки в покомпонентном виде
	 */
	@Override
	public String toString() {
		return this.s+" + "+this.x+"i + "+this.y+"j + "+this.z+"k";
	}
	/**
	 * Сумма кватернионов
	 * @param b Кватернион
	 * @return
	 */
	public Quaternion sum(Quaternion b) {
		Quaternion res=new Quaternion(this.s+b.s,this.x+b.x,this.y+b.y,this.z+b.z );
		return res;
	}
	/**
	 * Разность кватернионов
	 * @param b Кватернион
	 * @return
	 */
	public Quaternion sub(Quaternion b) {
		Quaternion res=new Quaternion(this.s-b.s,this.x-b.x,this.y-b.y,this.z-b.z );
		return res;
	}
	/**
	 * Произведение кватернионов
	 * @param b Кватернион
	 * @return
	 */
	public Quaternion mul(Quaternion b) {
		Quaternion res=new Quaternion();
		res.s=this.s*b.s-this.x*b.x-this.y*b.y-this.z*b.z;
		res.x=this.s*b.x+b.s*this.x+this.y*b.z-b.y*this.z;
		res.y=this.s*b.y+b.s*this.y+this.z*b.x-b.z*this.x;
		res.z=this.s*b.z+b.s*this.z+this.x*b.y-b.x*this.y;
		return res;
	}
	/**
	 * Умножение на скаляр
	 * @param sc Скаляр
	 * @return
	 */
	public Quaternion scalarMul(double sc) {
		Quaternion res=new Quaternion(this.s*sc,this.x*sc,this.y*sc,this.z*sc);
		return res;
	}	
	/**
	 * Сопряженный кватернион
	 * @return
	 */
	public Quaternion conjugate() {
		Quaternion res=new Quaternion(this.s,-this.x,-this.y,-this.z);
		return res;
	}
	/**
	 * Модуль кватерниона
	 * @return
	 */
	public double magnitude() {
		return Math.sqrt(Math.pow(s, 2)+Math.pow(x, 2)+Math.pow(y, 2)+Math.pow(z, 2));
	}
	/**
	 * Нормализация кватерниона
	 * @return
	 */
	public Quaternion magnitudealize() {		
		Quaternion res=new Quaternion(this.scalarMul(1/this.magnitude()));
		return res;
	}
	/**
	 * Обратный кватернион
	 * @return
	 */
	public Quaternion inverse() {	
		Quaternion res=new Quaternion(this.conjugate().scalarMul(Math.pow(this.magnitude(), 2)));
		return res;
	}
	/**
	 * Скалярное произведение кватерионов
	 * @param b Кватернион
	 * @return
	 */
	public double innerProduct(Quaternion b) {
		return this.s*b.s+this.x*b.x+this.y*b.y+this.z*b.z;
	}	
	/**
	 * Поворот кватерниона вокруг другого на заданный угол
	 * @param b Кватернион, вокруг которого осуществляется поворот
	 * @param ang Угол поворота в градусах
	 * @return
	 */
	public Quaternion rotate(Quaternion b, double ang) {
		Quaternion q=new Quaternion(Math.cos(Math.toRadians(ang*1/2)),Math.sin(Math.toRadians(ang*1/2))*b.x,Math.sin(Math.toRadians(ang*1/2))*b.y,Math.sin(Math.toRadians(ang*1/2))*b.z);
		Quaternion res=new Quaternion(q.mul(this).mul(q.conjugate()));
		return res;
	}

	

}

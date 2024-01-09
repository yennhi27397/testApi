package OopExercise.bai7;

public class Officer {
  public float luongCung;
  public float luongThuong;
  public float tienPhat;
  public float luongThucLinh;
  public Teacher teacher;

  public Officer(float luongCung, float luongThuong, float tienPhat, Teacher officer) {
    this.luongCung = luongCung;
    this.luongThuong = luongThuong;
    this.tienPhat = tienPhat;
    this.teacher = officer;
  }

  public float getLuongCung() {
    return luongCung;
  }

  public float getLuongThuong() {
    return luongThuong;
  }

  public float getTienPhat() {
    return tienPhat;
  }

  public float getLuongThucLinh() {
    return luongThucLinh;
  }

  public Teacher getTeacher() {
    return teacher;
  }
}

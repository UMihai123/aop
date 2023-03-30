public interface IController {
    void ShowSchools();

    void ShowClasses(int schoolId);

    void ShowStudents(int classId);

    void ShowClassBookPages(int studentId);

    void ShowTeachers(int subjectId);

    void ShowSubjects(int schoolId);

    void CreateSchool();

    void CreateClass(int schoolId);

    void CreateStudent(int schoolId);

    void CreateTeachers(int subjectId);

    void CreateSubject(int schoolId);
}

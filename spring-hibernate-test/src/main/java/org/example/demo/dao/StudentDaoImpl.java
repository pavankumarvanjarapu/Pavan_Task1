package org.example.demo.dao;

import java.util.List;

import javax.persistence.Query;

import org.example.demo.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value = "studentDao")
public class StudentDaoImpl implements StudentDao {
	private SessionFactory sessionFactory;

	@Autowired
	public StudentDaoImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Student> getAll() {
		// TODO Auto-generated method stub
		Session sn = sessionFactory.openSession();
		sn.getTransaction().begin();
		Query q = sn.createQuery("FROM Student", Student.class);
		List<Student> l = q.getResultList();
		for (Student s : l) {
			System.out.println(s);
		}
		sn.getTransaction().commit();

		return l;
	}

	@Override
	public Student createStudent(Student student) {
		// TODO Auto-generated method stub
		Session sn = sessionFactory.openSession();
		sn.getTransaction().begin();
		sn.save(student);
		sn.getTransaction().commit();
		return student;
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		Session sn = sessionFactory.openSession();
		sn.getTransaction().begin();
		Query q = sn.createQuery("FROM Student", Student.class);
		List<Student> l = q.getResultList();
		for (Student s : l) {
			sn.remove(s);
		}
		sn.getTransaction().commit();

	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		Session sn = sessionFactory.openSession();
		sn.getTransaction().begin();
		String db = "FROM Student where id=" + id;
		Query query = sn.createQuery(db, Student.class);
		List<Student> list = query.getResultList();
		if (!list.isEmpty()) {
			for (Student s : list) {

				sn.delete(s);

				System.out.println("one item deleted...");

			}
		} else {
			System.out.println("no such id found: " + id);
		}

		sn.getTransaction().commit();

	}

	@Override
	public List<Student> findById(int id) {
		// TODO Auto-generated method stub
		Session sn = sessionFactory.openSession();
		sn.getTransaction().begin();
		String dbQuery = "FROM Student where id=" + id;
		Query query = sn.createQuery(dbQuery, Student.class);
		List<Student> st =query.getResultList();
		if (!st.isEmpty()) {
			System.out.println("found:" + st);
			return st;
		} else {
			System.out.println("no such id found: " + id);
		}
		sn.getTransaction().commit();
		return null;
		
	}

	@Override
	public void findByDate(String date) {
		// TODO Auto-generated method stub
		Session sn = sessionFactory.openSession();
		sn.getTransaction().begin();
		String dbQuery = "FROM Student where enteringDate= " + "'" + date + "'";
		Query query = sn.createQuery(dbQuery, Student.class);
		List<Student> sts = query.getResultList();
		if (!sts.isEmpty()) {
			for (Student s : sts) {
				System.out.println("found:" + s);
			}
		} else {
			System.out.println("There is no Student Entered with this date: " + date);
		}

		sn.getTransaction().commit();

	}

	@Override
	public void findStudentByName(String name) {
		// TODO Auto-generated method stub
		Session sn = sessionFactory.openSession();
		sn.getTransaction().begin();

		Query query = sn.createQuery("FROM Student", Student.class);
		List<Student> list = query.getResultList();
		for (Student s : list) {

			if (s.getName().equals(name)) {

				System.out.println("found:" + s);

			} else {
				System.out.println("There is no Student Entered with this date: " + name);
			}
		}
		sn.getTransaction().commit();

	}

	@Override
	public Student updateById(int id, Student student) {
		// TODO Auto-generated method stub
		findById(id);
		Session sn = sessionFactory.openSession();
		sn.getTransaction().begin();

		Query query = sn.createQuery("FROM Student", Student.class);
		Student s = (Student) query.getSingleResult();

		if (s != null) {
			s.setName(student.getName());
			s.setEnteringDate(student.getEnteringDate());
			s.setNationality(student.getNationality());
			sn.merge(s);
			System.out.println(s);
		} else {
			System.out.println("not there");
		}

		sn.getTransaction().commit();
		return null;
	}

	@Override
	public Student findByName(String name) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		String db = "FROM Student where name=" + "'" + name + "'";
		Query query = session.createQuery(db, Student.class);

		List<Student> student = query.getResultList();
		if (!student.isEmpty()) {
			for (Student s : student) {
//			if (s.getName().equals(name)) {

				System.out.println(" element found...." + s);

			}
		}

		else {

			System.out.println("No such student found");

		}

		session.getTransaction().commit();
		return null;
	}

	@Override
	public Student updateByName(String name, Student student) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		String db = "FROM Student where name=" + "'" + name + "'";
		Query query = session.createQuery(db, Student.class);

		List<Student> student1 = query.getResultList();
		if (!student1.isEmpty()) {
			for (Student s : student1) {

				System.out.println(" element found...." + s);
				s.setName(student.getName());
				s.setEnteringDate(student.getEnteringDate());
				s.setCode(student.getCode());
				s.setNationality(student.getNationality());
				session.merge(s);

			}
		}

		else {

			System.out.println("No such student found");

		}

		session.getTransaction().commit();
		return null;
	}

}

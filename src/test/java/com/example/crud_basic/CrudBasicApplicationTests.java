package com.example.crud_basic;

import com.example.crud_basic.entity.Student;
import com.example.crud_basic.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Optional;

@SpringBootTest
class CrudBasicApplicationTests {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private StudentService studentService;
	@Test
	public void testGetStudentById() throws Exception {
		// Mock data
		Student mockStudent = new Student();
		mockStudent.setId(1L);
		mockStudent.setFirstName("John Doe");
		mockStudent.setAge(25);

		// Mock service behavior
		given(studentService.getStudentById(1L)).willReturn(Optional.of(mockStudent));

		// Perform the GET request and assert the result
		mockMvc.perform(MockMvcRequestBuilders.get("/students/1")
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
				.andExpect(MockMvcResultMatchers.jsonPath("$.name").value("John Doe"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.age").value(25));
	}

}

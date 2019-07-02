package com.multazamgsd.academy.ui.academy;

import com.multazamgsd.academy.data.CourseEntity;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class AcademyViewModelTest {
    private AcademyViewModel viewModel;

    @Before
    public void setUp() {
        viewModel = new AcademyViewModel();
    }

    @After
    public void tearDown() {}

    @Test
    public void getCourse() {
        List<CourseEntity> courseEntities = viewModel.getCourse();
        assertNotNull(courseEntities);
        assertEquals(5, courseEntities.size());
    }
}
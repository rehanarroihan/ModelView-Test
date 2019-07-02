package com.multazamgsd.academy.ui.bookmark;

import com.multazamgsd.academy.data.CourseEntity;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class BookmarkViewModelTest {
    private BookmarkViewModel viewModel;

    @Before
    public void setUp() {
        viewModel = new BookmarkViewModel();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void getBookmark() {
        List<CourseEntity> courseEntities = viewModel.getBookmarks();
        assertNotNull(courseEntities);
        assertEquals(5, courseEntities.size());
    }
}
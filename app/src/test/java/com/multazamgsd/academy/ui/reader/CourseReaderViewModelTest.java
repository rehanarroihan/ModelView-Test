package com.multazamgsd.academy.ui.reader;

import com.multazamgsd.academy.data.ContentEntity;
import com.multazamgsd.academy.data.ModuleEntity;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class CourseReaderViewModelTest {

    private CourseReaderViewModel viewModel;
    private ContentEntity mContent;
    private String moduleId;

    @Before
    public void setUp() {
        viewModel = new CourseReaderViewModel();
        viewModel.setCourseId("a14");

        moduleId = "a14m1";

        String title = viewModel.getModules().get(0).getTitle();
        mContent = new ContentEntity("<h3 class=\\\"fr-text-bordered\\\">" + title + "</h3><p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>");
    }

    @Test
    public void getModules() {
        ArrayList<ModuleEntity> moduleEntities = viewModel.getModules();
        assertNotNull(moduleEntities);
        assertEquals(7, moduleEntities.size());
    }

    @Test
    public void getSelectedModule() {
        viewModel.setSelectedModule(moduleId);

        ModuleEntity moduleEntity = viewModel.getSelectedModule();
        assertNotNull(moduleEntity);

        ContentEntity contentEntity = moduleEntity.contentEntity;
        assertNotNull(contentEntity);

        String content = contentEntity.getmContent();
        assertNotNull(content);
        assertEquals(content, mContent.getmContent());
    }
}
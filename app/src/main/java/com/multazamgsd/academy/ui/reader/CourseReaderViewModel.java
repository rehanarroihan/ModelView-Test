package com.multazamgsd.academy.ui.reader;

import androidx.lifecycle.ViewModel;

import com.multazamgsd.academy.data.ContentEntity;
import com.multazamgsd.academy.data.ModuleEntity;
import com.multazamgsd.academy.utils.DataDummy;

import java.util.ArrayList;

public class CourseReaderViewModel extends ViewModel {
    private String courseId;
    private String moduleId;

    public ArrayList<ModuleEntity> getModules() {
        return DataDummy.generateDummyModules(courseId);
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public ModuleEntity getSelectedModule() {
        ModuleEntity module = null;
        for (int i = 0; i < getModules().size(); i++) {
            if (getModules().get(i).getModuleId().equals(moduleId)) {
                module = getModules().get(i);

                module.contentEntity = new ContentEntity("<h3 class=\\\"fr-text-bordered\\\">" + module.getTitle() + "</h3><p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>");
                break;
            }
        }
        return module;
    }

    public void setSelectedModule(String moduleId) {
        this.moduleId = moduleId;
    }
}

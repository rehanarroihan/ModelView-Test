package com.multazamgsd.academy.ui.academy;

import androidx.lifecycle.ViewModel;

import com.multazamgsd.academy.data.CourseEntity;
import com.multazamgsd.academy.utils.DataDummy;

import java.util.List;

public class AcademyViewModel extends ViewModel {

    public List<CourseEntity> getCourse() {
        return DataDummy.generateDummyCourses();
    }
}

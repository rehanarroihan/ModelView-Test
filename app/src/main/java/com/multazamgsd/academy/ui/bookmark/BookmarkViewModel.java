package com.multazamgsd.academy.ui.bookmark;

import androidx.lifecycle.ViewModel;

import com.multazamgsd.academy.data.CourseEntity;
import com.multazamgsd.academy.utils.DataDummy;

import java.util.List;

public class BookmarkViewModel extends ViewModel {

    List<CourseEntity> getBookmarks() {
        return DataDummy.generateDummyCourses();
    }
}

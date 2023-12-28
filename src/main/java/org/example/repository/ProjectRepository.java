package org.example.repository;

import org.example.domain.Project;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ProjectRepository {
    private List<Project> projectList;

    public ProjectRepository() {
        this.projectList = new ArrayList<>();
    }

    public void addProject(Project project) {
        projectList.add(project);
    }

    public Project getProjectById(UUID id) {
        for (Project project : projectList) {
            if (project.getId().equals(id)) {
                return project;
            }
        }
        return null; // Proje bulunamazsa null döner
    }

    public List<Project> getProjectList() {
        return new ArrayList<>(projectList); // Projelerin bir kopyasını döner
    }

    public void deleteProject(UUID id) {
        projectList.removeIf(project -> project.getId().equals(id));
    }

}

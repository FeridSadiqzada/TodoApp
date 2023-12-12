package org.example.service;
import org.example.Main;
import org.example.domain.Project;
import org.example.repository.ProjectRepository;
import java.util.Scanner;
import java.util.UUID;
import java.util.List;

public class ProjectService {
    private ProjectRepository projectRepository;
    private TodoService todoService;
    private Scanner scanner = new Scanner(System.in);

    public ProjectService(ProjectRepository projectRepository, TodoService todoService) {
        this.projectRepository = projectRepository;
        this.todoService = todoService;
    }

    public void manageProjects() {
        while (true) {
            System.out.println("Yeni bir proje yaratmak istiyor musunuz? (Evet/Hayır)");
            String cevap = scanner.nextLine();

            if ("Evet".equalsIgnoreCase(cevap)) {
                createNewProject();
            } else if ("Hayır".equalsIgnoreCase(cevap)) {
                if (projectRepository.getProjectList().isEmpty()) {
                    System.out.println("Mevcut proje yok.");
                } else {
                    accessExistingProject();
                }
            } else {
                System.out.println("Geçersiz seçim. Lütfen 'Evet' veya 'Hayır' yazın.");
            }

            System.out.println("Devam etmek istiyor musunuz? (Evet/Hayır)");
            if ("Hayır".equalsIgnoreCase(scanner.nextLine())) {
                break;
            }
        }
    }

    private void createNewProject() {
        System.out.println("Proje başlığını girin:");
        String title = scanner.nextLine();
        Project newProject = new Project(UUID.randomUUID(), title);
        projectRepository.addProject(newProject);
        System.out.println("Yeni proje oluşturuldu: " + title);
    }

    private void accessExistingProject() {
        System.out.println("Mevcut projeler:");
        List<Project> projects = projectRepository.getProjectList();
        projects.forEach(project -> System.out.println("ID: " + project.getId() + ", Başlık: " + project.getTitle()));

        System.out.println("Daxil olmaq istediğiniz proje ID'sini girin:");
        UUID projectId = UUID.fromString(scanner.nextLine());
        Project selectedProject = projectRepository.getProjectById(projectId);

        if (selectedProject != null) {
            System.out.println("Şu anki proje: " + selectedProject.getTitle());
            // Burada todoService metodlarını çağırabilirsiniz. Örneğin:
            // todoService.addTask();
            // todoService.readTasks();
            new Main().todoController.run();
        } else {
            System.out.println("Proje bulunamadı.");
        }
    }
}

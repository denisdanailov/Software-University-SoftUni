package hiberspring.service;

import java.io.IOException;

public interface BranchService {
    String BRANCHES_FILE_PATH = "src/main/resources/files/branches.json";

    Boolean branchesAreImported();

    String readBranchesJsonFile() throws IOException;

    String importBranches(String branchesFileContent);
}

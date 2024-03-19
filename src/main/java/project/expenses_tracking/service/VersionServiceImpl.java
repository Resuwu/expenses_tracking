package project.expenses_tracking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.expenses_tracking.model.Version;
import project.expenses_tracking.repository.VersionHistory;

@Service
public class VersionServiceImpl implements VersionService{
    private final VersionHistory versionHistory;
    @Autowired
    public VersionServiceImpl(VersionHistory versionHistory) {
        this.versionHistory = versionHistory;
    }
    public Version readLastVersion() {
        return versionHistory.findFirstByOrderByIdDesc();
    }
}

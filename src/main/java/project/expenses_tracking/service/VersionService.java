package project.expenses_tracking.service;

import project.expenses_tracking.model.Version;

public interface VersionService {
    Version readLastVersion();
}

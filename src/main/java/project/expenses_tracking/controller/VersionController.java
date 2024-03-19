package project.expenses_tracking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;
import project.expenses_tracking.model.Version;
import project.expenses_tracking.service.VersionServiceImpl;

import java.util.concurrent.ForkJoinPool;

@RestController
@RequestMapping("/version")
public class VersionController {
    private final VersionServiceImpl service;

    @Autowired
    public VersionController(VersionServiceImpl service) {
        this.service = service;
    }
    @GetMapping
    public DeferredResult<ResponseEntity<String>> checkVersion() {
        DeferredResult<ResponseEntity<String>> out = new DeferredResult<>();
        out.onTimeout(() -> out.setErrorResult(ResponseEntity.status(HttpStatus.REQUEST_TIMEOUT)));
        ForkJoinPool.commonPool().submit(() -> {
            Version version = service.readLastVersion();
            if ((version == null) || version.getVersion().isEmpty())
                out.setResult(new ResponseEntity<>(HttpStatus.NOT_FOUND));
            else out.setResult(new ResponseEntity<>(version.getVersion(), HttpStatus.OK));
        });
        return out;
    }
}

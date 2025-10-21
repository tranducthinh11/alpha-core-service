package vn.alphabank.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.alphabank.request.OpenAccContractRequestDTO;
import vn.alphabank.service.BankService;

@RestController
@RequestMapping("/api")
public class BankController extends BaseController {

    private static final Logger LOG = LoggerFactory.getLogger(BankController.class);

    @Autowired
    BankService bankService;

    @GetMapping("/searchCif")
    public ResponseEntity<?> searchCif(@RequestHeader String traceId, @RequestHeader String flowId,
                                       @RequestHeader String flowCode, @RequestHeader String stmId,
                                       @RequestParam String idType, @RequestParam String cbsIdType,
                                       @RequestParam String idNumber, @RequestParam(required = false) String fullName) {
        LOG.info("traceId: {}, flowId: {}, flowCode: {}, stmId: {}",traceId,flowId,flowCode,stmId);
        return getResponse(() -> bankService.searchCif(stmId, idType, cbsIdType, idNumber, fullName, flowCode));
    }

    @GetMapping("/cbs/customer")
    public ResponseEntity<?> searchCustomer(@RequestHeader String traceId, @RequestHeader String flowId,
                                            @RequestHeader String flowCode, @RequestHeader String stmId,
                                            @RequestParam String cif, @RequestParam String cbs) {
        logger.info("traceId: {}, flowId: {}, flowCode: {}, stmId: {}",traceId,flowId,flowCode,stmId);
        return getResponse(() -> bankService.searchCustomer(stmId, cif, cbs));
    }

    @PostMapping("/cbs/contract")
    public ResponseEntity<?> submitContract(@RequestHeader String traceId, @RequestHeader String flowId,
                                            @RequestHeader String flowCode, @RequestHeader String stmId,
                                            @RequestBody OpenAccContractRequestDTO rq) {
        logger.info("traceId: {}, flowId: {}, flowCode: {}, stmId: {}",traceId,flowId,flowCode,stmId);
        return getResponse(() -> bankService.submitContract(rq));
    }
}

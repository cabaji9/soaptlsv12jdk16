import com.hson.sri.generated.RecepcionComprobantesOffline;
import com.hson.sri.generated.RecepcionComprobantesOfflineService;
import com.hson.sri.generated.RespuestaSolicitud;
import org.junit.Before;
import org.junit.Test;

/**
 * hson
 * 27/5/21
 */
public class PruebaSoap {

    private RecepcionComprobantesOffline recepcionComprobantesOffline;

    @Before
    public void setup(){
        RecepcionComprobantesOfflineService recepcionComprobantesOfflineService = new RecepcionComprobantesOfflineService();
        recepcionComprobantesOffline =recepcionComprobantesOfflineService.getRecepcionComprobantesOfflinePort();
    }


    @Test
    public void testCall(){
        byte[] array = new byte[199];
       RespuestaSolicitud respuestaSolicitud = recepcionComprobantesOffline.validarComprobante(array);
        System.out.println(respuestaSolicitud);
    }



}

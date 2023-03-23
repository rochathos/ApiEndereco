package testes;

import com.br.cadastro.endereco.EnderecoApplication;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ApiApplication {
    @Test
    void main(){
        EnderecoApplication.main(new String[] {});
    }
}

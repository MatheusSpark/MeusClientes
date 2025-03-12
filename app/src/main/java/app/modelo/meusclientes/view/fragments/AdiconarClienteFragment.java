package app.modelo.meusclientes.view.fragments;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import app.modelo.meusclientes.R;
import app.modelo.meusclientes.controller.ClienteController;
import app.modelo.meusclientes.model.Cliente;


public class AdiconarClienteFragment extends Fragment {
    // Fragment - Classe responsável pela camada de VISÃO (Layout)
    View view;
    EditText etNome;
    EditText etTelefone;
    EditText etEmail;
    EditText etCep;
    EditText etLogadouro;
    EditText etNumero;
    EditText etBairro;
    EditText etCidade;
    EditText etEstado;
    CheckBox cbTermosDeUso;
    Button btnSalvar;
    Button btnCancelar;
    ClienteController clienteController;
    Cliente cliente;
    public AdiconarClienteFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_adiconar_cliente, container, false);
        clienteController = new ClienteController(this.getContext());
        cliente = new Cliente();
        initComponentes();
        listenerClick();
        return view;
    }


    private void initComponentes() {
        etNome = view.findViewById(R.id.etNome);
        etTelefone = view.findViewById(R.id.etTelefone);
        etEmail = view.findViewById(R.id.etEmail);
        etCep = view.findViewById(R.id.etCep);
        etLogadouro = view.findViewById(R.id.etLogadouro);
        etNumero = view.findViewById(R.id.etNumero);
        etBairro = view.findViewById(R.id.etBairro);
        etCidade = view.findViewById(R.id.etCidade);
        etEstado = view.findViewById(R.id.etEstado);
        cbTermosDeUso = view.findViewById(R.id.cbTermosDeUso);
        btnSalvar = view.findViewById(R.id.btnSalvar);
        btnCancelar = view.findViewById(R.id.btnCancelar);
    }

    private void listenerClick() {
        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isDadosOk = true;
                if(TextUtils.isEmpty(etNome.getText())){
                    etNome.setError("Digite o nome");
                    etNome.requestFocus();
                    isDadosOk = false;
                }
                if(TextUtils.isEmpty(etTelefone.getText())){
                    etTelefone.setError("Digite o telefone");
                    etTelefone.requestFocus();
                    isDadosOk = false;
                }
                if(TextUtils.isEmpty(etEmail.getText())){
                    etEmail.setError("Digite o email");
                    etEmail.requestFocus();
                    isDadosOk = false;
                }
                if(TextUtils.isEmpty(etCep.getText())){
                    etCep.setError("Digite o cep");
                    etCep.requestFocus();
                    isDadosOk = false;
                }
                if(TextUtils.isEmpty(etLogadouro.getText())){
                    etLogadouro.setError("Digite o logadouro");
                    etLogadouro.requestFocus();
                    isDadosOk = false;
                }
                if(TextUtils.isEmpty(etNumero.getText())){
                    etNumero.setError("Digite o número");
                    etNumero.requestFocus();
                    isDadosOk = false;
                }
                if(TextUtils.isEmpty(etBairro.getText())){
                    etBairro.setError("Digite o bairro");
                    etBairro.requestFocus();
                    isDadosOk = false;
                }
                if(TextUtils.isEmpty(etCidade.getText())){
                    etCidade.setError("Digite a cidade");
                    etCidade.requestFocus();
                    isDadosOk = false;
                }
                if(TextUtils.isEmpty(etEstado.getText())){
                    etEstado.setError("Digite o estado");
                    etEstado.requestFocus();
                    isDadosOk = false;
                }
                if(!cbTermosDeUso.isChecked()){
                    cbTermosDeUso.setError("Favor ler e aceitar os termos de uso");
                    cbTermosDeUso.requestFocus();
                    isDadosOk = false;
                }
                if(isDadosOk){
                    cliente.setNome(etNome.getText().toString());
                    cliente.setTelefone(etTelefone.getText().toString());
                    cliente.setEmail(etEmail.getText().toString());
                    cliente.setCep(Integer.parseInt(etCep.getText().toString()));
                    cliente.setLogradouro(etLogadouro.getText().toString());
                    cliente.setNumero(etNumero.getText().toString());
                    cliente.setBairro(etBairro.getText().toString());
                    cliente.setCidade(etCidade.getText().toString());
                    cliente.setEstado(etEstado.getText().toString());
                    cliente.setTermosDeUso(cbTermosDeUso.isChecked());
                    clienteController.incluir(cliente);

                    Toast.makeText(getActivity(), "Cliente salvo com sucesso!", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getActivity(), "Erro ao salvar", Toast.LENGTH_SHORT).show();
                }

            }
        });
        cbTermosDeUso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}

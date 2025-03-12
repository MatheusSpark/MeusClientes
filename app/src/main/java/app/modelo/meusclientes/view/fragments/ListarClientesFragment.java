package app.modelo.meusclientes.view.fragments;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import app.modelo.meusclientes.R;
import app.modelo.meusclientes.controller.ClienteController;
import app.modelo.meusclientes.model.Cliente;

public class ListarClientesFragment extends Fragment {
    // Fragment - Classe responsável pela camada de VISÃO (Layout)
    View view;
    EditText etPequisar;
    ListView lvListaClientes;
    List<String> clientes;
    ClienteController clienteController;
    Cliente cliente;
    ArrayAdapter<String> clienteAdapter;
    ArrayList<HashMap<String, String>> filtroClientes;

    public ListarClientesFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view =  inflater.inflate(R.layout.fragment_listar_clietes, container, false);
        TextView txtTitulo = view.findViewById(R.id.txtTitulo);
        clienteController = new ClienteController(getContext());
        lvListaClientes = (ListView) view.findViewById(R.id.lvListaClientes);
        etPequisar = view.findViewById(R.id.etPesquisar);
        clientes = new ArrayList<>();
        clientes = clienteController.gerarListaDeClientesListView();
        clienteAdapter = new ArrayAdapter<>(Objects.requireNonNull(getContext()), R.layout.listar_cliente_item, R.id.tvCliente, clientes);
        lvListaClientes.setAdapter(clienteAdapter);
        etPequisar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence filtro, int i, int i1, int i2) {
                ListarClientesFragment.this.clienteAdapter.getFilter().filter(filtro);
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        return view;
    }


}

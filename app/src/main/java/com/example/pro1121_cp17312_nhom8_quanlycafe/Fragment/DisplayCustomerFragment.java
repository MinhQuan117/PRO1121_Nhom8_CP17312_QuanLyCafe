package com.example.pro1121_cp17312_nhom8_quanlycafe.Fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;

import com.example.pro1121_cp17312_nhom8_quanlycafe.Activities.AddCustomer;
import com.example.pro1121_cp17312_nhom8_quanlycafe.Activities.PaymentActivity;
import com.example.pro1121_cp17312_nhom8_quanlycafe.Adapter.AdapterDisplayCustomer;
import com.example.pro1121_cp17312_nhom8_quanlycafe.DAO.KhachHangDAO;
import com.example.pro1121_cp17312_nhom8_quanlycafe.DAO.NhanVienDAO;
import com.example.pro1121_cp17312_nhom8_quanlycafe.DTO.KhachHangDTO;
import com.example.pro1121_cp17312_nhom8_quanlycafe.DTO.NhanVienDTO;
import com.example.pro1121_cp17312_nhom8_quanlycafe.MainActivity;
import com.example.pro1121_cp17312_nhom8_quanlycafe.R;

import java.util.List;

public class DisplayCustomerFragment extends Fragment {

    ListView lvcustomer;
    KhachHangDAO khachHangDAO;
    List<KhachHangDTO> khachHangDTOS;
    AdapterDisplayCustomer adapterDisplayCustomer;

    ActivityResultLauncher<Intent> resultLauncherAdd = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if(result.getResultCode() == Activity.RESULT_OK){
                        Intent intent = result.getData();
                        long ktra = intent.getLongExtra("ketquaktra",0);
                        String chucnang = intent.getStringExtra("chucnang");
                        if(chucnang.equals("themkh"))
                        {
                            if(ktra != 0){
                                HienThiDSKH();
                                Toast.makeText(getActivity(),"Th??m th??nh c??ng",Toast.LENGTH_SHORT).show();
                            }else {
                                Toast.makeText(getActivity(),"Th??m th???t b???i",Toast.LENGTH_SHORT).show();
                            }
                        }else {
                            if(ktra != 0){
                                HienThiDSKH();
                                Toast.makeText(getActivity(),"S???a th??nh c??ng",Toast.LENGTH_SHORT).show();
                            }else {
                                Toast.makeText(getActivity(),"S???a th???t b???i",Toast.LENGTH_SHORT).show();
                            }
                        }

                    }
                }
            });

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.displaycustomer_layout,container,false);
        ((MainActivity)getActivity()).getSupportActionBar().setTitle("Qu???n l?? kh??ch h??ng");
        setHasOptionsMenu(true);

        lvcustomer = (ListView) view.findViewById(R.id.lvcustomer) ;

        khachHangDAO = new KhachHangDAO(getActivity());
        HienThiDSKH();

        registerForContextMenu(lvcustomer);

        return view;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu,View v,ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getActivity().getMenuInflater().inflate(R.menu.edit_menu,menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id = item.getItemId();
        AdapterView.AdapterContextMenuInfo menuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int vitri = menuInfo.position;
        int makh = khachHangDTOS.get(vitri).getMAKH();
        Intent intent = new Intent(getActivity(), PaymentActivity.class);
        Bundle tuidung = new Bundle();
        tuidung.putString("tenKH",khachHangDTOS.get(vitri).getHOTENKH());
        intent.putExtras(tuidung);
        startActivity(intent);
        switch (id){
            case R.id.itEdit:
                Intent iEdit = new Intent(getActivity(), AddCustomer.class);
                iEdit.putExtra("makh",makh);
                resultLauncherAdd.launch(iEdit);
                break;


        }

        return true;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        MenuItem itAddStaff = menu.add(1,R.id.itAddCustomer ,1,"Th??m kh??ch h??ng");
        itAddStaff.setIcon(R.drawable.ic_baseline_add_24);
        itAddStaff.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.itAddCustomer:
                Intent iDangky = new Intent(getActivity(), AddCustomer.class);
                resultLauncherAdd.launch(iDangky);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void HienThiDSKH(){
        khachHangDTOS = khachHangDAO.LayDSKH();
        adapterDisplayCustomer = new AdapterDisplayCustomer(getActivity(),R.layout.custom_layout_displaycustomer,khachHangDTOS);
        lvcustomer.setAdapter(adapterDisplayCustomer);
        adapterDisplayCustomer.notifyDataSetChanged();
    }
}

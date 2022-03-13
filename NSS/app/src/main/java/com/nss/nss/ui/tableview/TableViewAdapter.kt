package com.nss.nss.ui.tableview

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.nss.nss.data.db.Historico
import com.nss.nss.databinding.ItemTableviewBinding


class TableViewAdapter() :
    RecyclerView.Adapter<TableViewAdapter.ViewHolder>() {


    private var listaHistoricos: List<Historico> = arrayListOf()

    fun setData(lista: List<Historico>) {
        listaHistoricos = lista
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: ItemTableviewBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(historico: Historico){
            with(binding){
                tvId.text=historico.id.toString()
                tvFecha.text=historico.fecha
                tvDbm.text=historico.dbm
                tvAsu.text=historico.asu
                tvCodigo.text=historico.codigo
                tvRed.text=historico.red
                tvTipoRed.text=historico.tipoRed
            }
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(viewGroup.context)
        val binding = ItemTableviewBinding.inflate(layoutInflater,viewGroup,false)
        return ViewHolder(binding)
    }


    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.bind(listaHistoricos[position])
    }


    override fun getItemCount() = listaHistoricos.size

}

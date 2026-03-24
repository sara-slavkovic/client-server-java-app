/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package communication;

import java.io.Serializable;

/**
 *
 * @author Korisnik
 */
public enum Operation implements Serializable {

    LOGIN,
    KRAJ_RADA,
    SACUVAJ_KORISNIKA,
    VRATI_SVE_KURSEVE,
    SACUVAJ_KURS,
    VRATI_SVE_TIPOVE_SMINKANJA,
    VRATI_SVE_PREDAVACE,
    OBRISI_KURS,
    VRATI_KURSEVE_NAZIV,
    IZMENI_KURS,
    VRATI_SVE_GRUPE,
    VRATI_MAKS_ID_GRUPA,
    VRATI_GRUPU,
    SACUVAJ_PRIJAVU,
    VRATI_GRUPE_NAZIV,
    VRATI_SVE_RASPOREDE,
    SACUVAJ_GRUPU,
    VRATI_SVE_PRIJAVE,
    IZMENI_PRIJAVU
}
